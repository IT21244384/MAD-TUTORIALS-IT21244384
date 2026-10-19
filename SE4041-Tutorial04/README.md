# SE4041 – Tutorial 04: Room Database

Android Views project (Kotlin): add, view, update and delete records stored in a Room (SQLite) database,
shown in a RecyclerView, with fragments + a shared ViewModel.

## Open and run
Android Studio ▸ **File ▸ Open** ▸ select this folder ▸ Gradle sync ▸ ▶ Run.
(minSdk 26, compileSdk 35, Kotlin 2.0.21, AGP 8.7.3, Room 2.6.1 via kapt, package `com.example.roomtutorial`.)

## Where each part of the sheet lives (`app/src/main/java/com/example/roomtutorial/`)
| Sheet part | Files |
|---|---|
| Part 01 – fragments, MainActivity | `MainActivity.kt`, `InsertRecordFragment.kt`, `ViewRecordsFragment.kt`, `res/layout/activity_main.xml`, `fragment_insert_record.xml`, `fragment_view_records.xml` |
| Part 02 – database | `database/entities/MyTable.kt`, `database/daos/MyTableDao.kt`, `database/MyDatabase.kt`, `database/repository/MyTableRepositories.kt` |
| Part 02 – RecyclerView | `res/layout/list_item_layout.xml`, `MyDataVH.kt`, `MyDataAdapter.kt` |
| Part 03 – insert data | `InsertRecordFragment.kt`, `MainActivityData.insertData` |
| Part 04 – view data | `MainActivityData.kt`, `ViewRecordsFragment.kt` |
| Part 04 – update data | see below |

## "Update Data" (the sheet leaves these code boxes empty)
The sheet's last section lists five steps with no code. They are implemented like this:
1. `MainActivityData` – `updateData`, `deleteData` and a `selectedItem` LiveData.
2. `InsertRecordFragment` – if a record is selected it opens in **update mode** (title "Update Record",
   fields pre-filled, Insert disabled, Update enabled); otherwise insert mode (Update disabled, as in Part 03).
3. `MyDataAdapter` – Update / Delete buttons call `onUpdate` / `onDelete` callbacks (`handleUpdate` / `handleDelete`).
4. `ViewRecordsFragment` – passes callbacks: Update selects the record and opens the form, Delete removes it and refreshes the list.
5. `MainActivity.loadInsertFragment` – made public so fragments can call it; "Add Record" clears the selection first.

## Small differences from the sheet
- Room **2.6.1** instead of 2.5.2 (works with current Kotlin/AGP); still kapt.
- `viewModelScope` instead of `CoroutineScope(Dispatchers.Main/IO)` so coroutines are cancelled with the ViewModel.
- Observers use `viewLifecycleOwner` instead of the activity, otherwise every visit to the list adds another observer.
- `insertSuccess` is set after the insert has finished, then reset, so the form clears and the toast shows once.
- Blank-name validation and toasts added; list rows show name and date of birth.
