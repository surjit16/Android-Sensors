package com.richamster.app.sensorsdemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;

public class CalculateSensorValueActivity extends AppCompatActivity implements SensorEventListener {

    static int TYPE;
    public String TAG = this.getClass().getSimpleName();
    SensorManager sensorManager;
    Sensor sensor;
    TextView sensorValues, sensorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_sensor_value);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        try {
            sensorName = findViewById(R.id.sensorName);
            sensorValues = findViewById(R.id.sensorValues);
            TYPE = Integer.parseInt(getIntent().getDataString());
            sensor = sensorManager.getDefaultSensor(TYPE);
        } catch (Exception e) {
            finish();
        }

        sensorName.setText(sensor.getName());
        sensorValues.setText("---");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sensor != null)
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            sensorValues.setText(sensor.getName() + " not present");
            Log.e(TAG, "onResume " + sensor.getName() + " not present");
        }
    }

    @Override
    protected void onPause() {
        if (sensor != null)
            sensorManager.unregisterListener(this, sensor);
        else
            Log.e(TAG, "onPause " + sensor.getName() + " not present");
        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        float[] values;
        if (sensorType == TYPE) {
            values = event.values;
            sensorValues.setText(Arrays.toString(values));
        }
        Log.e(TAG, "in onSensorChanged " + sensorType);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        int sensorType = sensor.getType();
        Log.e(TAG, "in onAccuracyChanged " + sensorType);
    }
}
