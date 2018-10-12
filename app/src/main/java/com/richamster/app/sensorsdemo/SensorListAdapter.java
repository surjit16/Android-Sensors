package com.richamster.app.sensorsdemo;

import android.content.Context;
import android.hardware.Sensor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SensorListAdapter extends ArrayAdapter<Sensor> {

    public SensorListAdapter(@NonNull Context context, int resource, List<Sensor> sensorList) {
        super(context, resource, sensorList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_sensor_list, parent, false);
        }
        TextView view = convertView.findViewById(R.id.name);
        view.setText(getItem(position).getName());
        TextView version = convertView.findViewById(R.id.version);
        version.setText(getItem(position).getVersion()+"");
        TextView vendor = convertView.findViewById(R.id.vendor);
        vendor.setText(getItem(position).getVendor());
        return convertView;
    }
}
