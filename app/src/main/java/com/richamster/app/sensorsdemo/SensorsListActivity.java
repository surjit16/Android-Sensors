package com.richamster.app.sensorsdemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.richamster.app.sensorsdemo.adapter.SensorsListAdapter;

import java.util.ArrayList;
import java.util.List;

public class SensorsListActivity extends AppCompatActivity {

    SensorManager sensorManager;
    RecyclerView recyclerSensorView;
    SensorsListAdapter recyclerAdapter;
    List<Sensor> sensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors_list);
        recyclerSensorView = findViewById(R.id.recycler_view);
        sensorList = new ArrayList<>();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        recyclerAdapter = new SensorsListAdapter(this, sensorList);
        recyclerSensorView.setAdapter(recyclerAdapter);
    }
}
