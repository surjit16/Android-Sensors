package com.richamster.app.sensorsdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.richamster.app.sensorsdemo.R;
import com.richamster.app.sensorsdemo.data.SensorDetailsData;

import java.util.List;

public class SensorDetailsAdapter extends RecyclerView.Adapter<SensorDetailsAdapter.MyVH> {

    Context mContext;
    List<SensorDetailsData> sensorDetailsDataList;

    public SensorDetailsAdapter(Context context, List<SensorDetailsData> sensorDetailsDataList) {
        mContext = context;
        this.sensorDetailsDataList = sensorDetailsDataList;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_sensors_details, viewGroup, false);
        return new MyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH myVH, int i) {
        final SensorDetailsData sensor = sensorDetailsDataList.get(i);
        myVH.type.setText(sensor.getType());
        myVH.value.setText(sensor.getValue());
    }

    @Override
    public int getItemCount() {
        return sensorDetailsDataList.size();
    }

    class MyVH extends RecyclerView.ViewHolder {
        TextView type, value;

        MyVH(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            value = itemView.findViewById(R.id.value);
        }
    }
}