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

public class RotationActivity extends AppCompatActivity implements SensorEventListener {

    String TAG = "AnotherActivity";
    SensorManager sensorManager;
    Sensor gravitySensor, accelerometerSensor, magneticSensor, rotationSensor;
    TextView gravitySensorValues, accelerometerSensorValues, magneticSensorValues, rotationSensorValues, rotationManualValues;

    private float[] mAccelerometerData = new float[3];
    private float[] mMagnetometerData = new float[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        gravitySensorValues = findViewById(R.id.gravitySensorValues);
        accelerometerSensorValues = findViewById(R.id.accelerometerSensorValues);
        magneticSensorValues = findViewById(R.id.magneticSensorValues);
        rotationSensorValues = findViewById(R.id.rotationSensorValues);
        rotationManualValues = findViewById(R.id.rotationManualValues);

        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magneticSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        rotationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (gravitySensor != null)
            sensorManager.registerListener(this, gravitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            gravitySensorValues.setText("Gravity Sensor not present");
            Log.e(TAG, "onResume gravitySensor not present");
        }
        if (accelerometerSensor != null)
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            accelerometerSensorValues.setText("Accelerometer Sensor not present");
            Log.e(TAG, "onResume accelerometerSensor not present");
        }
        if (magneticSensor != null)
            sensorManager.registerListener(this, magneticSensor, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            magneticSensorValues.setText("Magnetic Sensor not present");
            Log.e(TAG, "onResume magneticSensor not present");
        }
        if (rotationSensor != null)
            sensorManager.registerListener(this, rotationSensor, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            rotationSensorValues.setText("Rotation Sensor not present");
            Log.e(TAG, "onResume rotationSensor not present");
        }
    }

    @Override
    protected void onPause() {

        if (gravitySensor != null)
            sensorManager.unregisterListener(this, gravitySensor);
        else Log.e(TAG, "onPause gravitySensor not present");
        if (accelerometerSensor != null)
            sensorManager.unregisterListener(this, accelerometerSensor);
        else Log.e(TAG, "onPause accelerometerSensor not present");
        if (magneticSensor != null)
            sensorManager.unregisterListener(this, magneticSensor);
        else Log.e(TAG, "onPause magneticSensor not present");
        if (rotationSensor != null)
            sensorManager.unregisterListener(this, rotationSensor);
        else Log.e(TAG, "onPause rotationSensor not present");
        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        int sensorType = event.sensor.getType();
        float[] values;
        switch (sensorType) {
            case Sensor.TYPE_GRAVITY:
                values = event.values;
                gravitySensorValues.setText(Arrays.toString(values));
                break;
            case Sensor.TYPE_ACCELEROMETER:
                values = event.values;
                mAccelerometerData = values.clone();
                accelerometerSensorValues.setText(Arrays.toString(values));
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                values = event.values;
                mMagnetometerData = values.clone();
                magneticSensorValues.setText(Arrays.toString(values));
                break;
            case Sensor.TYPE_ROTATION_VECTOR:
                values = event.values;
                rotationSensorValues.setText(Arrays.toString(values));
                break;
        }

        float[] rotationMatrix = new float[9];
        boolean rotationOK = SensorManager.getRotationMatrix(rotationMatrix,
                null, mAccelerometerData, mMagnetometerData);
        float orientationValues[] = new float[3];
        if (rotationOK) {
            SensorManager.getOrientation(rotationMatrix, orientationValues);
            double dd = (180 / Math.PI);
            double azimuth = orientationValues[0] * dd;
            double pitch = orientationValues[1] * dd;
            double roll = orientationValues[2] * dd;
            rotationManualValues.setText("[" + azimuth + ", " + pitch + ", " + roll + "]");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
