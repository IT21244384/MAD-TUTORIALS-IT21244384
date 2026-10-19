# SE4041 – Tutorial 03: Fragments

Android Views project (Kotlin) for the SLIIT SE4041 *Fragments* tutorial.
The sheet says to name the project **Tutorial 04**, so the app/package is `com.example.tutorial04`.

This is the **final version** of the sheet (after the "Challenge" step): the Walking / Cycling /
Driving buttons live in `MenuFragment`, and a shared `ViewModel` tells `MainActivity` which
fragment to show.

```
MenuFragment ──click──▶ MainActivityData (ViewModel, LiveData<Int> 1/2/3)
                                   │ observe
                                   ▼
                          MainActivity ──replace──▶ WalkingFragment | CyclingFragment | DrivingFragment
```

## Open and run
Android Studio ▸ **File ▸ Open** ▸ select this folder ▸ wait for Gradle sync ▸ ▶ Run.
(minSdk 26, compileSdk 35, Kotlin 2.0.21, AGP 8.7.3.)

## Where each tutorial step lives
| Step | File |
|---|---|
| 2 – activity layout (two FrameLayouts) | `res/layout/activity_main.xml` |
| 3–5 – Walking / Cycling / Driving fragments | `*Fragment.kt`, `res/layout/fragment_{walking,cycling,driving}.xml`, vector icons in `res/drawable` |
| 6 – fragment objects, `walk()` `cycle()` `drive()` | `MainActivity.kt` |
| 7 – button click inside a fragment (inflate + colour toggle) | `CyclingFragment.kt`, `fragment_cycling.xml` |
| Challenge – `MenuFragment`, `loadMenu()` | `MenuFragment.kt`, `fragment_menu.xml` |
| ViewModel | `MainActivityData.kt` |

## Notes
- Fragment layouts use ConstraintLayout with the icon centred (all four constraints).
- Icons are Material "directions_walk / directions_bike / directions_car" vector drawables.
- `color1` / `color2` (used by the Change Background Color button) are not given in the sheet; I chose two light colours.
- The final sheet instruction *"implement a method to keep the color in the memory"* is done by
  storing the chosen colour in `MainActivityData.cyclingBackground`; `CyclingFragment` restores it
  in `onCreateView`. See `SUBMISSION-NOTES.md`.
