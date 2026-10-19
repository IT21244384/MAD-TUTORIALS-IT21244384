# Submission notes – Tutorial 02

## One difference between LinearLayout and ConstraintLayout
A **LinearLayout** places its children in a single line, either vertical or horizontal
(`android:orientation`), so a child's position is decided only by its order in the list.
A **ConstraintLayout** positions each child by *constraints* (to the parent, another view or a
guideline), so views can be placed freely in two dimensions without deep nesting, which suits
screens that must adapt to different sizes and orientations.

## Test checklist (Step 13) – add a screenshot after tests 2, 4 and 6
| # | Action | Expected result | Done |
|---|---|---|---|
| 1 | Launch app | LoginActivity opens | ☐ |
| 2 | Tap *Create a new account* | MainActivity opens in portrait  📸 | ☐ |
| 3 | Rotate device | Landscape: fields left, buttons right | ☐ |
| 4 | Mismatched passwords, tap Subscribe | "Passwords do not match." appears  📸 | ☐ |
| 5 | Matching passwords, tap Subscribe | Account saved, LoginActivity opens | ☐ |
| 6 | Log in with saved credentials | Dashboard shows "Welcome, username"  📸 | ☐ |
| 7 | Tap Back | Dashboard closes, LoginActivity visible | ☐ |
| 8 | Force-stop and reopen app | Credentials gone (in-memory only) – expected | ☐ |

## Knowledge check – answers
1. `0dp` with constraints on both sides means "match constraints" – the view stretches between them.
2. `layout-land` supplies resources used when the device is in landscape orientation.
3. The same Kotlin code calls `findViewById`, so both layouts must contain the same IDs.
4. `startActivity(...)` adds a new activity on top; `finish()` removes the current one.
5. An Intent extra is small, temporary, screen-to-screen data.
6. `MyCredentials` keeps plain in-memory data: no secure authentication, no persistence.
