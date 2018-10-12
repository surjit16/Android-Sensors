# Android-Sensors

In This We Use Android Sensors and calculate its value.


1. We get the all sensors list which are present in device.

                   // Getting the SENSOR SERVICE from Device
                   sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

                   // Getting the SENSOR List from sensorManager
                   // It returns the List<Sensor>
                   sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

2. After Displaying the List of Sensor OnClick to the Sensor from list passing the sensor Type in intet Sensor


                   myVH.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mContext, SensorDetailsActivity.class);

                            // this value is used for getting details of spesific sensor
                            intent.setData(Uri.parse(sensor.getType()+"")); 
                            mContext.startActivity(intent);
                        }
                    });
           
3. In SensorDetailsActivity First getting the sensor type that was passed as intent

                    int sensorType = Integer.parseInt(getIntent().getDataString());
                    // Getting the Sensor object of sensorType
                    Sensor sensor = sensorManager.getDefaultSensor(sensorType);

                    // You can also use
                    // Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                                                                    // Sensor.TYPE_LIGHT
                                                                    //Sensor.TYPE_MAGNETIC_FIELD
                    // specific to your use
   
   and then get the value from sensor object like
   sensor.getName(), sensor.getStringType(), sensor.getVendor(), sensor.getPower(), etc
   and display in the list
   
   Here we also have the CalculateValue Button.
   on Click this button it calculate the value using the sensor.
           
4. For calculate the value we go to the another activity and registered the sensor 

  Important this activity must  implements SensorEventListener for getting the change in the value of sensor
  
  SensorEventListener  has two method and We have to Override both
                        
                 // Trigger when any change in the value of sensor
                 @Override
                 public void onSensorChanged(SensorEvent event) {
                 }
                          
                 // Trigger when any change accuracy of Sensor
                 @Override
                 public void onAccuracyChanged(Sensor sensor, int accuracy) {
                 }
                          
  In CalculateSensorValueActivity
    
                 TYPE = Integer.parseInt(getIntent().getDataString()); // getting the type of sensor from intent
                 sensor = sensorManager.getDefaultSensor(TYPE); // getting the sesor object
            
  For getting the sensor value We have to register it. As sensor consume power and resourses. so it is good practise to resister the sensor in onResume method i.e. when activity is visible to user and unregisterListener in  onPause method i.e. if activity is not visible deactivate the sensor / remove the listner for value change.
    
                @Override
                protected void onResume() {
                    super.onResume();
                    if (sensor != null) // check if sensor is present in device or not
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

