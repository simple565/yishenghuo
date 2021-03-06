package com.maureen.yishenghuo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.maureen.yishenghuo.R;
import com.maureen.yishenghuo.activity.ElectricApplyActivity;
import com.maureen.yishenghuo.activity.GasApplyActivity;
import com.maureen.yishenghuo.activity.ParkApplyActivity;
import com.maureen.yishenghuo.activity.PropertyApplyActivity;
import com.maureen.yishenghuo.activity.WaterApplyActivity;
import com.maureen.yishenghuo.neighborhood.MessageActivity;
import com.maureen.yishenghuo.servicesupport.ApplianceRepairActivity;
import com.maureen.yishenghuo.servicesupport.AsideActivity;
import com.maureen.yishenghuo.servicesupport.ComplainActivity;
import com.maureen.yishenghuo.servicesupport.EntranceActivity;
import com.maureen.yishenghuo.servicesupport.HouseKeepingActivity;
import com.maureen.yishenghuo.servicesupport.IllegalityActivity;
import com.maureen.yishenghuo.servicesupport.NoticeActivity;
import com.maureen.yishenghuo.servicesupport.PropertyPhoneActivity;
import com.maureen.yishenghuo.servicesupport.RepairsActivity;
import com.maureen.yishenghuo.servicesupport.WashingActivity;
import com.maureen.yishenghuo.servicesupport.WeatherActivity;
import com.maureen.yishenghuo.ui.TitleBar;


public class ServiceFragment extends Fragment implements View.OnClickListener {
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
        TitleBar mTitleBar = view.findViewById(R.id.service_titlebar);
        mTitleBar.setText("服务");
        mTitleBar.setRightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MessageActivity.class));
            }
        });

        //居家生活
        TextView mtv_housekeeping = (TextView) view.findViewById(R.id.service_tv_housekeeping);
        mtv_housekeeping.setOnClickListener(this);
        TextView mtv_entrance = (TextView) view.findViewById(R.id.service_tv_entrance);
        mtv_entrance.setOnClickListener(this);
        TextView mtv_appliance_repair = view.findViewById(R.id.service_tv_appliance_repair);
        mtv_appliance_repair.setOnClickListener(this);
        TextView mtv_wash = view.findViewById(R.id.service_tv_wash);
        mtv_wash.setOnClickListener(this);

        //小区物业
        TextView mtv_propertyAnnounce = view.findViewById(R.id.service_tv_propertyannounce);
        mtv_propertyAnnounce.setOnClickListener(this);
        TextView mtv_communityAnnounce = view.findViewById(R.id.service_tv_announce);
        mtv_communityAnnounce.setOnClickListener(this);
        TextView mtv_complain = view.findViewById(R.id.service_tv_complain);
        mtv_complain.setOnClickListener(this);
        TextView mtv_repair = view.findViewById(R.id.service_tv_repair);
        mtv_repair.setOnClickListener(this);

        //充值缴费
        TextView mtv_property = (TextView) view.findViewById(R.id.service_tv_propertyfee);
        mtv_property.setOnClickListener(this);
        TextView mtv_gas = (TextView) view.findViewById(R.id.service_tv_gasfee);
        mtv_gas.setOnClickListener(this);
        TextView mtv_water = (TextView) view.findViewById(R.id.service_tv_water);
        mtv_water.setOnClickListener(this);
        TextView mtv_parking = (TextView) view.findViewById(R.id.service_tv_parkingfee);
        mtv_parking.setOnClickListener(this);
        TextView mtv_electric = (TextView) view.findViewById(R.id.service_tv_electric);
        mtv_electric.setOnClickListener(this);
        //便民消息
        TextView mtv_weather = (TextView) view.findViewById(R.id.service_tv_weatherquery);
        mtv_weather.setOnClickListener(this);
        TextView mtv_trafficquery = (TextView) view.findViewById(R.id.service_tv_trafficquery);
        mtv_trafficquery.setOnClickListener(this);
        TextView mtv_aside = view.findViewById(R.id.service_tv_aside);
        mtv_aside.setOnClickListener(this);
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
            case R.id.service_tv_appliance_repair:
                startActivity(new Intent(getActivity(), ApplianceRepairActivity.class));
                break;
            case R.id.service_tv_wash:
                startActivity(new Intent(getActivity(), WashingActivity.class));
                break;
            case R.id.service_tv_propertyannounce:
                startActivity(new Intent(getActivity(), NoticeActivity.class));
                break;
            case R.id.service_tv_announce:
                startActivity(new Intent(getActivity(), PropertyPhoneActivity.class));
                break;
            case R.id.service_tv_complain:
                startActivity(new Intent(getActivity(), ComplainActivity.class));
                break;
            case R.id.service_tv_repair:
                startActivity(new Intent(getActivity(), RepairsActivity.class));
                break;
            case R.id.service_tv_propertyfee:
                startActivity(new Intent(getActivity(), PropertyApplyActivity.class));
                break;
            case R.id.service_tv_weatherquery:
                startActivity(new Intent(getActivity(), WeatherActivity.class));
                break;
            case R.id.service_tv_gasfee:
                startActivity(new Intent(getActivity(), GasApplyActivity.class));
                break;
            case R.id.service_tv_water:
                startActivity(new Intent(getActivity(), WaterApplyActivity.class));
                break;
            case R.id.service_tv_electric:
                startActivity(new Intent(getActivity(), ElectricApplyActivity.class));
                break;
            case R.id.service_tv_parkingfee:
                startActivity(new Intent(getActivity(), ParkApplyActivity.class));
                break;
            case R.id.service_tv_trafficquery:
                startActivity(new Intent(getActivity(), IllegalityActivity.class));
                break;
            case R.id.service_tv_aside:
                startActivity(new Intent(getActivity(), AsideActivity.class));
            default:
                break;
        }
    }
}

