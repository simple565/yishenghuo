package com.yishenghuo.yishenghuo.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.utils.DistanceUtil;
import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.ui.TitleBar;
import java.util.List;

public class MapActivity extends AppCompatActivity implements BDLocationListener{

    private TitleBar mTitleBar;
    private BaiduMap mBaiduMap = null;

    private ImageView iv_left;
    protected static final String TAG = "MapActivity——mwork";
    private ListView lv_near_address;
    private SuggestionSearch mSuggestionSearch = null;
    private double latitude;
    private double longitude;

    private ArrayAdapter<String> sugAdapter = null;
    private MapView map;
    private MyLocationConfiguration.LocationMode mCurrentMode;
    private LocationClient mLocClient;
    private GeoCoder geoCoder;
    private String city;
    private boolean isFirstLoc = true;
    private LatLng locationLatLng;

    private LatLng ll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SDKInitializer.initialize(getApplicationContext());
        initView();
    }

    public void initView() {
        mTitleBar = (TitleBar) findViewById(R.id.map_titlebar);
        mTitleBar.setText("位置定位");
        mTitleBar.setLeftButton(R.drawable.ic_arrow_left);

        map = (MapView) findViewById(R.id.map);
        mBaiduMap = map.getMap();
        MapStatus mapStatus = new MapStatus.Builder().zoom(15).build();
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
        mBaiduMap.setMapStatus(mMapStatusUpdate);
        // 地图状态改变相关监听
        //mBaiduMap.setOnMapStatusChangeListener(this);
        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        // 定位图层显示方式
        mCurrentMode = MyLocationConfiguration.LocationMode.NORMAL;
        mBaiduMap.setMyLocationConfigeration(new MyLocationConfiguration(mCurrentMode, true, null));
        mLocClient = new LocationClient(this);
        // 注册定位监听
        mLocClient.registerLocationListener(this);
        // 定位选项
        LocationClientOption option = new LocationClientOption();
        /**
         * coorType - 取值有3个：
         * 返回国测局经纬度坐标系：gcj02
         * 返回百度墨卡托坐标系 ：bd09
         * 返回百度经纬度坐标：bd09ll
         */
        option.setCoorType("bd09ll");
        // 设置是否需要地址信息，默认为无地址
        option.setIsNeedAddress(true);
        // 设置是否需要返回位置语义化信息，可以在BDLocation.getLocationDescribe()中得到数据，ex:"在天安门附近"，
        // 可以用作地址信息的补充
        option.setIsNeedLocationDescribe(true);
        // 设置是否需要返回位置POI信息，可以在BDLocation.getPoiList()中得到数据
        option.setIsNeedLocationPoiList(true);
        /**
         * 设置定位模式 Battery_Saving 低功耗模式 Device_Sensors 仅设备(Gps)模式 Hight_Accuracy
         * 高精度模式
         */
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        // 设置是否打开gps进行定位
        option.setOpenGps(true);
        // 设置扫描间隔，单位是毫秒 当<1000(1s)时，定时定位无效
        option.setScanSpan(1000);
        // 设置 LocationClientOption
        mLocClient.setLocOption(option);
        // 开始定位
        mLocClient.start();
        lv_near_address = (ListView) findViewById(R.id.lv_near_address);
        // 初始化搜索模块，注册搜索事件监听
        mSuggestionSearch = SuggestionSearch.newInstance();
        //mSuggestionSearch.setOnGetSuggestionResultListener(this);
        sugAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);
    }

    /*
     * 接受周边地理位置结果
     */

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
        map.onDestroy();
        if (geoCoder != null) {
            geoCoder.destroy();
        }
        map = null;
        mSuggestionSearch.destroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }


    public void onResume() {
        super.onResume();
        map.onResume();
        if (getIntent().getStringExtra("latitude") != null &&
                (!"".equals(getIntent().getStringExtra("latitude")))) {
            latitude = Double.parseDouble(getIntent().getStringExtra("latitude"));
            longitude = Double.parseDouble(getIntent().getStringExtra("longitude"));
        }
    }

    public void onPause() {
        super.onPause();
        map.onPause();
    }


    //@Override
    public void onGetSuggestionResult(SuggestionResult res) {
        if (res == null || res.getAllSuggestions() == null) {
            return;
        }
        sugAdapter.clear();
        for (SuggestionResult.SuggestionInfo info : res.getAllSuggestions()) {
            if (info.key != null)
                sugAdapter.add(info.key + " " + info.city + info.district);
        }
        sugAdapter.notifyDataSetChanged();
    }


    //@Override
    public void onMapStatusChange(MapStatus mapStatus) {

    }

    //@Override
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        // 地图操作的中心点
        LatLng cenpt = mapStatus.target;
        geoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(cenpt));
    }

   // @Override
    public void onMapStatusChangeStart(MapStatus mapStatus) {

    }

   // @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        // 如果bdLocation为空或mapView销毁后不再处理新数据接收的位置
        if (bdLocation == null || mBaiduMap == null) {
            return;
        }
        // 定位数据
        MyLocationData data = new MyLocationData.Builder()
                // 定位精度bdLocation.getRadius()
                .accuracy(bdLocation.getRadius())
                // 此处设置开发者获取到的方向信息，顺时针0-360
                .direction(bdLocation.getDirection())
                // 经度
                .latitude(bdLocation.getLatitude())
                // 纬度
                .longitude(bdLocation.getLongitude())
                // 构建
                .build();

        // 设置定位数据
        mBaiduMap.setMyLocationData(data);

        // 是否是第一次定位
        if (isFirstLoc) {
            isFirstLoc = false;
            ll = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
            Toast.makeText(MapActivity.this, ll + "", Toast.LENGTH_SHORT).show();
            MapStatusUpdate msu = MapStatusUpdateFactory.newLatLngZoom(ll, 18);
            mBaiduMap.animateMapStatus(msu);
        }

        locationLatLng = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
        // 获取城市，待会用于POISearch
        city = bdLocation.getCity();

        // 创建GeoCoder实例对象
        geoCoder = GeoCoder.newInstance();
        // 发起反地理编码请求(经纬度->地址信息)
        ReverseGeoCodeOption reverseGeoCodeOption = new ReverseGeoCodeOption();
        // 设置反地理编码位置坐标
        reverseGeoCodeOption.location(new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude()));
        geoCoder.reverseGeoCode(reverseGeoCodeOption);

        // 设置查询结果监听者
      //  geoCoder.setOnGetGeoCodeResultListener(this);
    }

   // @Override
    public void onGetGeoCodeResult(GeoCodeResult arg0) {

    }

    // 拿到变化地点后的附近地址
   // @Override
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
        final List<PoiInfo> poiInfos = reverseGeoCodeResult.getPoiList();
        Log.i(TAG, "这里的值:" + poiInfos);
        if (poiInfos != null && !"".equals(poiInfos)) {
            PoiAdapter poiAdapter = new PoiAdapter(MapActivity.this, poiInfos);
            mLocClient.stop();
            lv_near_address.setAdapter(poiAdapter);
            lv_near_address.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String
                            name = poiInfos.get(position).name.toString();

                    LatLng latLng = poiInfos.get(position).location;
                    double lat = poiInfos.get(position).location.latitude;
                    double lon = poiInfos.get(position).location.longitude;
                    Toast.makeText(MapActivity.this, name + lat + lon + "", Toast.LENGTH_LONG).show();

                    System.out.println(ll + "==" + latLng + "=====" + DistanceUtil.getDistance(ll, latLng) + "===================");


                }
            });
        }
    }



    /**
     * listview列表适配器
     */
    class PoiAdapter extends BaseAdapter {
        private Context context;
        private List<PoiInfo> pois;
        private LinearLayout linearLayout;

        PoiAdapter(Context context, List<PoiInfo> pois) {
            this.context = context;
            this.pois = pois;
        }

        @Override
        public int getCount() {
            return pois.size();
        }

        @Override
        public Object getItem(int position) {
            return pois.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.mapitem, null);
                linearLayout = (LinearLayout) convertView.findViewById(R.id.locationpois_linearlayout);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) {
                holder.locationpoi_name.setTextColor(Color.parseColor("#FF9D06"));
                holder.locationpoi_address.setTextColor(Color.parseColor("#FF9D06"));
            }
            if (position == 0 && linearLayout.getChildCount() < 2) {
                ImageView imageView = new ImageView(context);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(32, 32);
                imageView.setLayoutParams(params);
                imageView.setBackgroundColor(Color.TRANSPARENT);
                imageView.setImageResource(R.drawable.ic_gps);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                linearLayout.addView(imageView, 0, params);
                holder.locationpoi_name.setTextColor(Color.parseColor("#FF5722"));
            }
            PoiInfo poiInfo = pois.get(position);
            holder.locationpoi_name.setText(poiInfo.name);
            holder.locationpoi_address.setText(poiInfo.address);
            return convertView;
        }

        class ViewHolder {
            ImageView iv_gps;
            TextView locationpoi_name;
            TextView locationpoi_address;

            ViewHolder(View view) {
                locationpoi_name = (TextView) view.findViewById(R.id.locationpois_name);
                locationpoi_address = (TextView) view.findViewById(R.id.locationpois_address);
                iv_gps = (ImageView) view.findViewById(R.id.iv_gps);
            }
        }
    }

}
