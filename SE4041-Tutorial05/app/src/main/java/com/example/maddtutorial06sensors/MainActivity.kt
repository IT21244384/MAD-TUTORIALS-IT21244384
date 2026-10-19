package com.example.maddtutorial06sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var sensorManager: SensorManager

    // getDefaultSensor() returns null when the device has no such sensor
    var accelerometer: Sensor? = null
    var proximitySensor: Sensor? = null
    var lightSensor: Sensor? = null

    lateinit var sensorListener: SensorEventListener

    private fun initSensorListener(): SensorEventListener {
        val sensorListener = object : SensorEventListener {
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                // Handle accuracy changes if needed
            }

            val viewModel: MainActivityData =
                ViewModelProvider(this@MainActivity)[MainActivityData::class.java]

            override fun onSensorChanged(event: SensorEvent?) {
                if (event == null) return

                when (event.sensor.type) {
                    Sensor.TYPE_ACCELEROMETER -> {
                        val x = event.values[0]
                        val y = event.values[1]
                        val z = event.values[2]
                        viewModel.updateAccelerometerData("X: $x, Y: $y, Z: $z")
                    }

                    Sensor.TYPE_PROXIMITY -> {
                        val distance = event.values[0]
                        viewModel.updateProximityData("Distance: $distance")
                    }

                    Sensor.TYPE_LIGHT -> {
                        val lux = event.values[0]
                        viewModel.updateLightData("Lux: $lux")
                    }
                }
            }
        }

        return sensorListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvAccelaration: TextView = findViewById(R.id.tvAccelaration)
        val tvProximity: TextView = findViewById(R.id.tvProximity)
        val tvLight: TextView = findViewById(R.id.tvLight)

        // Initialize sensors
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        sensorListener = initSensorListener()

        val viewModel: MainActivityData = ViewModelProvider(this)[MainActivityData::class.java]

        viewModel.accelerometerData.observe(this) { data ->
            tvAccelaration.text = data
        }

        viewModel.proximityData.observe(this) { data ->
            tvProximity.text = data
        }

        viewModel.lightData.observe(this) { data ->
            tvLight.text = data
        }

        // Tell the user about any sensor this device does not have
        if (accelerometer == null) {
            tvAccelaration.text = getString(R.string.sensor_not_available, "Accelerometer")
        }
        if (proximitySensor == null) {
            tvProximity.text = getString(R.string.sensor_not_available, "Proximity")
        }
        if (lightSensor == null) {
            tvLight.text = getString(R.string.sensor_not_available, "Light")
        }
    }

    override fun onResume() {
        super.onResume()
        accelerometer?.let {
            sensorManager.registerListener(sensorListener, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
        proximitySensor?.let {
            sensorManager.registerListener(sensorListener, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
        lightSensor?.let {
            sensorManager.registerListener(sensorListener, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        // Stop listening while the app is in the background (saves battery)
        sensorManager.unregisterListener(sensorListener)
    }
}
