package com.richamster.app.sensorsdemo;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.richamster.app.sensorsdemo.adapter.SensorDetailsAdapter;
import com.richamster.app.sensorsdemo.data.SensorDetailsData;

import java.util.ArrayList;
import java.util.List;

public class SensorDetailsActivity extends AppCompatActivity {

    int sensorType;
    SensorManager sensorManager;
    Sensor sensor;
    List<SensorDetailsData> detailsData;

    RecyclerView recyclerSensorView;
    Button calValue;
    SensorDetailsAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_details);
        try {
            sensorType = Integer.parseInt(getIntent().getDataString());
        } catch (Exception e) {
            finish();
        }

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        recyclerSensorView = findViewById(R.id.recycler_view);

        sensor = sensorManager.getDefaultSensor(sensorType);
        if (sensor == null) finish();
        else {
            detailsData = new ArrayList<>();
            detailsData.add(new SensorDetailsData("Name", sensor.getName()));
            detailsData.add(new SensorDetailsData("Type", sensor.getStringType()));
            detailsData.add(new SensorDetailsData("Vendor", sensor.getVendor()));
            detailsData.add(new SensorDetailsData("Version", sensor.getVersion() + ""));
            detailsData.add(new SensorDetailsData("MaxDelay", sensor.getMaxDelay() + ""));
            detailsData.add(new SensorDetailsData("MinDelay", sensor.getMinDelay() + ""));
            detailsData.add(new SensorDetailsData("MaximumRange", sensor.getMaximumRange() + ""));
            detailsData.add(new SensorDetailsData("Power", sensor.getPower() + ""));
            detailsData.add(new SensorDetailsData("Resolution", sensor.getResolution() + ""));
        }

        recyclerAdapter = new SensorDetailsAdapter(this, detailsData);
        recyclerSensorView.setAdapter(recyclerAdapter);


        findViewById(R.id.calValue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SensorDetailsActivity.this, CalculateSensorValueActivity.class);
                intent.setData(Uri.parse(sensor.getType() + ""));
                startActivity(intent);
            }
        });
    }
}
