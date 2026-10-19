# SE4041 – Tutorial 05: Handling Sensors in Android

Reads the **accelerometer, proximity and light** sensors with `SensorManager` and shows the values live
through a ViewModel + LiveData. Package `com.example.maddtutorial06sensors` (as in the sheet).

## Open and run
Android Studio ▸ **File ▸ Open** ▸ select this folder ▸ Gradle sync ▸ ▶ Run.
(minSdk 26, compileSdk 35, Kotlin 2.0.21, AGP 8.7.3.) No permissions are needed for these sensors.

- **Physical phone:** move/tilt it (accelerometer), cover the top (proximity), shade/light it (light).
- **Emulator:** ⋯ (Extended controls) ▸ **Virtual sensors** ▸ *Device pose* (accelerometer) and *Additional sensors* (light, proximity).

## Files (`app/src/main/java/com/example/maddtutorial06sensors/`)
| Sheet part | File |
|---|---|
| UI (3 TextViews: `tvAccelaration`, `tvProximity`, `tvLight`) | `res/layout/activity_main.xml` |
| ViewModel | `MainActivityData.kt` |
| `initSensorListener()`, `onCreate`, `onResume`, `onPause` | `MainActivity.kt` |

## Differences from the sheet (all small fixes)
- The accelerometer was registered with `SENSOR_STATUS_ACCURACY_HIGH`. That is an *accuracy* constant, not a
  sampling rate (it is the number 3, i.e. 3 µs); it now uses `SENSOR_DELAY_NORMAL` like the other two.
- `getDefaultSensor()` returns `null` on devices without that sensor, which would crash with `lateinit var Sensor`.
  The sensors are now nullable, only registered if present, and the screen says "… sensor not available".
- `if (event == null) return` replaces the `event?.sensor?.type` chain so `event.values` needs no smart-cast.
- The id `tvAccelaration` keeps the sheet's spelling so the code matches the handout.

`onResume` registers and `onPause` unregisters the listener so the sensors stop draining the battery in the background.
