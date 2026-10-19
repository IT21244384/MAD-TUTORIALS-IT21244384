package com.example.roomtutorial.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomtutorial.database.entities.MyTable

@Dao
interface MyTableDao {

    @Insert
    suspend fun insert(myTable: MyTable)

    @Update
    suspend fun update(myTable: MyTable)

    @Delete
    suspend fun delete(myTable: MyTable)

    @Query("Select * from MyTable")
    suspend fun getAll(): List<MyTable>

    @Query("Select * from MyTable WHERE name = :name")
    suspend fun getOne(name: String): MyTable
}
