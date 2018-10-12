package com.richamster.app.sensorsdemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    SensorManager sensorManager;
    ListView listSensorView;
    Button getSensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listSensorView = findViewById(R.id.list_view);
        getSensorList = findViewById(R.id.get_sensors_list);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        getSensorList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Sensor> sensorLists = sensorManager.getSensorList(Sensor.TYPE_ALL);
                SensorListAdapter  adapter = new SensorListAdapter(MainActivity.this, R.layout.view_sensor_list, sensorLists);
                listSensorView.setAdapter(adapter);
            }
        });


    }
}
