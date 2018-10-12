package com.richamster.app.sensorsdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.richamster.app.sensorsdemo.R;
import com.richamster.app.sensorsdemo.SensorDetailsActivity;

import java.util.List;

public class SensorsListAdapter extends RecyclerView.Adapter<SensorsListAdapter.MyVH> {

    Context mContext;
    List<Sensor> sensorList;

    public SensorsListAdapter(Context context, List<Sensor> sensorList) {
        mContext = context;
        this.sensorList = sensorList;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_device_sensors_list, viewGroup, false);
        return new MyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH myVH, int i) {
        final Sensor sensor = sensorList.get(i);
        myVH.name.setText(sensor.getName());
        myVH.vendor.setText(sensor.getVendor());
        myVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SensorDetailsActivity.class);
                intent.setData(Uri.parse(sensor.getType()+""));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sensorList.size();
    }

    class MyVH extends RecyclerView.ViewHolder {
        TextView name, vendor;

        MyVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            vendor = itemView.findViewById(R.id.vendor);
        }
    }
}
