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

public class AnotherActivity extends AppCompatActivity implements SensorEventListener {

    String TAG = "AnotherActivity";
    SensorManager sensorManager;
    Sensor lightSensor, proxySensor, tempSensor, gravitySensor, pressureSensor, humiditySensor,
            accelerometerSensor, magneticSensor, rotationSensor, gyroscopeSensor, heartRateSensor;
    TextView lightSensorValues, proximitySensorValues, tempSensorValues, gravitySensorValues, pressureSensorValues, humiditySensorValues,
            accelerometerSensorValues, magneticSensorValues, rotationSensorValues, gyroscopeSensorValues, heartRateSensorValues;


    private float[] mAccelerometerData = new float[3];
    private float[] mMagnetometerData = new float[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        lightSensorValues = findViewById(R.id.lightSensorValues);
        proximitySensorValues = findViewById(R.id.proximitySensorValues);
        tempSensorValues = findViewById(R.id.tempSensorValues);
        gravitySensorValues = findViewById(R.id.gravitySensorValues);
        pressureSensorValues = findViewById(R.id.pressureSensorValues);
        humiditySensorValues = findViewById(R.id.humiditySensorValues);
        accelerometerSensorValues = findViewById(R.id.accelerometerSensorValues);
        magneticSensorValues = findViewById(R.id.magneticSensorValues);
        rotationSensorValues = findViewById(R.id.rotationSensorValues);
        gyroscopeSensorValues = findViewById(R.id.gyroscopeSensorValues);
        heartRateSensorValues = findViewById(R.id.heartRateSensorValues);

        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        proxySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        humiditySensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magneticSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        rotationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        heartRateSensor = sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (lightSensor != null)
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            lightSensorValues.setText("Light Sensor not present");
            Log.e(TAG, "onResume lightSensor not present");
        }
        if (proxySensor != null)
            sensorManager.registerListener(this, proxySensor, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            proximitySensorValues.setText("Proximity Sensor not present");
            Log.e(TAG, "onResume proxySensor not present");
        }
        if (tempSensor != null)
            sensorManager.registerListener(this, tempSensor, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            tempSensorValues.setText("Temperature Sensor not present");
            Log.e(TAG, "onResume tempSensor not present");
        }
        if (gravitySensor != null)
            sensorManager.registerListener(this, gravitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            gravitySensorValues.setText("Gravity Sensor not present");
            Log.e(TAG, "onResume gravitySensor not present");
        }
        if (pressureSensor != null)
            sensorManager.registerListener(this, pressureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            pressureSensorValues.setText("Pressure Sensor not present");
            Log.e(TAG, "onResume pressureSensor not present");
        }
        if (humiditySensor != null)
            sensorManager.registerListener(this, humiditySensor, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            humiditySensorValues.setText("Humidity Sensor not present");
            Log.e(TAG, "onResume humiditySensor not present");
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
        if (gyroscopeSensor != null)
            sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            gyroscopeSensorValues.setText("Gyroscope Sensor not present");
            Log.e(TAG, "onResume gyroscopeSensor not present");
        }
        if (heartRateSensor != null)
            sensorManager.registerListener(this, heartRateSensor, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            heartRateSensorValues.setText("Heart Rate Sensor not present");
            Log.e(TAG, "onResume heartRateSensor not present");
        }
    }

    @Override
    protected void onPause() {
        if (gravitySensor != null)
            sensorManager.unregisterListener(this, lightSensor);
        else
            Log.e(TAG, "onPause lightSensor not present");
        if (gravitySensor != null)
            sensorManager.unregisterListener(this, proxySensor);
        else Log.e(TAG, "onPause proxySensor not present");
        if (tempSensor != null)
            sensorManager.unregisterListener(this, tempSensor);
        else Log.e(TAG, "onPause tempSensor not present");
        if (gravitySensor != null)
            sensorManager.unregisterListener(this, gravitySensor);
        else Log.e(TAG, "onPause gravitySensor not present");
        if (pressureSensor != null)
            sensorManager.unregisterListener(this, pressureSensor);
        else Log.e(TAG, "onPause pressureSensor not present");
        if (humiditySensor != null)
            sensorManager.unregisterListener(this, humiditySensor);
        else Log.e(TAG, "onPause humiditySensor not present");
        if (accelerometerSensor != null)
            sensorManager.unregisterListener(this, accelerometerSensor);
        else Log.e(TAG, "onPause accelerometerSensor not present");
        if (magneticSensor != null)
            sensorManager.unregisterListener(this, magneticSensor);
        else Log.e(TAG, "onPause magneticSensor not present");
        if (rotationSensor != null)
            sensorManager.unregisterListener(this, rotationSensor);
        else Log.e(TAG, "onPause rotationSensor not present");
        if (gyroscopeSensor != null)
            sensorManager.unregisterListener(this, gyroscopeSensor);
        else Log.e(TAG, "onPause gyroscopeSensor not present");
        if (heartRateSensor != null)
            sensorManager.unregisterListener(this, heartRateSensor);
        else Log.e(TAG, "onPause heartRateSensor not present");
        super.onPause();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        int sensorType = event.sensor.getType();
        float[] values;
        switch (sensorType) {
            case Sensor.TYPE_LIGHT:
                values = event.values;
                lightSensorValues.setText(Arrays.toString(values));
                break;
            case Sensor.TYPE_PROXIMITY:
                values = event.values;
                proximitySensorValues.setText(Arrays.toString(values));
                break;
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                values = event.values;
                tempSensorValues.setText(Arrays.toString(values));
                break;
            case Sensor.TYPE_GRAVITY:
                values = event.values;
                gravitySensorValues.setText(Arrays.toString(values));
                break;
            case Sensor.TYPE_PRESSURE:
                values = event.values;
                pressureSensorValues.setText(Arrays.toString(values));
                break;
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                values = event.values;
                humiditySensorValues.setText(Arrays.toString(values));
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
            case Sensor.TYPE_GYROSCOPE:
                values = event.values;
                gyroscopeSensorValues.setText(Arrays.toString(values));
                break;
            case Sensor.TYPE_HEART_RATE:
                values = event.values;
                heartRateSensorValues.setText(Arrays.toString(values));
                break;
        }

        float[] rotationMatrix = new float[9];
        boolean rotationOK = SensorManager.getRotationMatrix(rotationMatrix,
                null, mAccelerometerData, mMagnetometerData);
        float orientationValues[] = new float[3];
        if (rotationOK) {
            SensorManager.getOrientation(rotationMatrix, orientationValues);
            float azimuth = orientationValues[0];
            float pitch = orientationValues[1];
            float roll = orientationValues[2];
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
