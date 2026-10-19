# SE4041 – Tutorial 02: Layouts, Activities, Navigation and Data Passing

Android Views project (Kotlin) from the SLIIT SE4041 Tutorial 02 sheet.

```
LoginActivity (launcher) ──Create new account──▶ MainActivity (register)
        ▲                                             │ Registration complete
        └─────────────────────────────────────────────┘
LoginActivity ──Login successful (putExtra "user_name")──▶ DashboardActivity (Back = finish())
```

## Open and run
1. Android Studio (Ladybug or newer) ▸ **File ▸ Open** ▸ select this folder `SE4041-Tutorial02`.
2. Let Gradle sync (needs internet the first time).
3. Pick an emulator or phone and press ▶ **Run 'app'**.

Package: `com.example.layouttutorial` · minSdk 26 · compileSdk 35 · Kotlin 2.0.21 · AGP 8.7.3.

## Where each tutorial step lives
| Step | File |
|---|---|
| 3 – colours, strings, icon | `res/values/colors.xml`, `strings.xml`, `res/drawable/ic_account.xml` |
| 4 – portrait registration | `res/layout/activity_main.xml` |
| 5 – landscape registration | `res/layout-land/activity_main.xml` |
| 6 – login layout | `res/layout/activity_login.xml` |
| 7 – dashboard layout | `res/layout/activity_dashboard.xml` |
| 8 – manifest / launcher | `app/src/main/AndroidManifest.xml` |
| 9 – singleton | `java/com/example/layouttutorial/model/MyCredentials.kt` |
| 10 – login logic | `LoginActivity.kt` |
| 11 – registration logic | `MainActivity.kt` |
| 12 – dashboard logic | `DashboardActivity.kt` |

Extra files the sheet does not list but Android needs: `res/values/themes.xml`
(defines `Theme.LayoutActivitiesTutorial`), the launcher icon in `res/mipmap-anydpi-v26`, and the Gradle files.

## Changes from the sheet
- `DashboardActivity` spelling used everywhere (the sheet corrects this itself).
- `MyCredentials.email = enteredEmail` (the corrected assignment the sheet describes).
- `activity_dashboard.xml`: added `layout_constraintTop_toTopOf="parent"` and
  `layout_constraintVertical_chainStyle="packed"` to `tvTitle`. Without a top constraint the
  title/message/Back views are not a complete vertical chain and would not be centred as the
  checkpoint describes.

See [`SUBMISSION-NOTES.md`](SUBMISSION-NOTES.md) for the test checklist, the LinearLayout vs
ConstraintLayout note and the knowledge-check answers.
