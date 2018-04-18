package com.yishenghuo.yishenghuo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yishenghuo.yishenghuo.R;
import com.yishenghuo.yishenghuo.activity.ElectricApplyActivity;
import com.yishenghuo.yishenghuo.activity.EntranceActivity;
import com.yishenghuo.yishenghuo.activity.GasApplyActivity;
import com.yishenghuo.yishenghuo.activity.HouseKeepingActivity;
import com.yishenghuo.yishenghuo.Neighborhood.MessageActivity;
import com.yishenghuo.yishenghuo.activity.ParkApplyActivity;
import com.yishenghuo.yishenghuo.activity.PropertyApplyActivity;
import com.yishenghuo.yishenghuo.activity.RepairsActivity;
import com.yishenghuo.yishenghuo.activity.WashingActivity;
import com.yishenghuo.yishenghuo.activity.WaterApplyActivity;
import com.yishenghuo.yishenghuo.ui.TitleBar;
import com.yishenghuo.yishenghuo.activity.WeatherActivity;


public class ServiceFragment extends Fragment implements View.OnClickListener {
    private TextView mtv_housekeeping, mtv_entrance;
    private TextView mtv_property,mtv_gas,mtv_water,mtv_parking,mtv_electric;
    private TextView mtv_weather;

    public ServiceFragment() {
        super();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        iniView(view);
        return view;
    }


    public void iniView(View view) {
        TitleBar mTitleBar = (TitleBar) view.findViewById(R.id.service_titlebar);
        mTitleBar.setText("服务");
        mTitleBar.setRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MessageActivity.class));
            }
        });
        mtv_housekeeping = (TextView) view.findViewById(R.id.service_tv_housekeeping);
        mtv_housekeeping.setOnClickListener(this);
        mtv_entrance = (TextView) view.findViewById(R.id.service_tv_entrance);
        mtv_entrance.setOnClickListener(this);
        mtv_property = (TextView) view.findViewById(R.id.service_tv_propertyfee);
        mtv_property.setOnClickListener(this);
        mtv_weather = (TextView) view.findViewById(R.id.service_tv_weatherquery);
        mtv_weather.setOnClickListener(this);
       mtv_gas = (TextView)view.findViewById(R.id.service_tv_gasfee);
       mtv_gas.setOnClickListener(this);
       mtv_water = (TextView)view.findViewById(R.id.service_tv_water);
       mtv_water.setOnClickListener(this);
       mtv_parking = (TextView)view.findViewById(R.id.service_tv_parkingfee);
       mtv_parking.setOnClickListener(this);
       mtv_electric = (TextView)view.findViewById(R.id.service_tv_electric);
       mtv_electric.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.service_tv_housekeeping:
                startActivity(new Intent(getActivity(), HouseKeepingActivity.class));
                break;
            case R.id.service_tv_entrance:
                startActivity(new Intent(getActivity(), EntranceActivity.class));
                break;
            case R.id.service_tv_repair:
                startActivity(new Intent(getActivity(), RepairsActivity.class));
                break;
            case R.id.service_tv_wash:
                startActivity(new Intent(getActivity(), WashingActivity.class));
            case R.id.service_tv_announce:
                //startActivity(new Intent(getActivity(), ));
                break;
            case R.id.service_tv_propertyfee:
                startActivity(new Intent(getActivity(), PropertyApplyActivity.class));
                break;
            case R.id.service_tv_weatherquery:
                startActivity(new Intent(getActivity(), WeatherActivity.class));
                break;
            case  R.id.service_tv_gasfee:
                startActivity(new Intent(getActivity(), GasApplyActivity.class));
                break;
            case R.id.service_tv_water:
                startActivity(new Intent(getActivity(), WaterApplyActivity.class));
                break;
            case  R.id.service_tv_parkingfee:
                startActivity(new Intent(getActivity(), ParkApplyActivity.class));
                break;
            case  R.id.service_tv_electric:
                startActivity(new Intent(getActivity(), ElectricApplyActivity.class));
                break;
            default:
                break;
        }
    }
}

