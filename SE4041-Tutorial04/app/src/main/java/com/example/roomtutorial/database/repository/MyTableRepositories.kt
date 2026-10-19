package com.example.roomtutorial.database.repository

import com.example.roomtutorial.database.MyDatabase
import com.example.roomtutorial.database.entities.MyTable

class MyTableRepositories(
    private val db: MyDatabase
) {
    suspend fun insert(myTable: MyTable) = db.getMyTableDao().insert(myTable)
    suspend fun update(myTable: MyTable) = db.getMyTableDao().update(myTable)
    suspend fun delete(myTable: MyTable) = db.getMyTableDao().delete(myTable)
    suspend fun getAll() = db.getMyTableDao().getAll()
    suspend fun getOne(name: String) = db.getMyTableDao().getOne(name)
}
