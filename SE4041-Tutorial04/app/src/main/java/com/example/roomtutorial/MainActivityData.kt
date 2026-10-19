package com.example.roomtutorial

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomtutorial.database.MyDatabase
import com.example.roomtutorial.database.entities.MyTable
import com.example.roomtutorial.database.repository.MyTableRepositories
import kotlinx.coroutines.launch

class MainActivityData : ViewModel() {
    private val _listMyTable = MutableLiveData<List<MyTable>>()
    private val _insertSuccess = MutableLiveData<Boolean>().apply { value = false }

    // Record chosen with the Update button in the list (null = adding a new record)
    private val _selectedItem = MutableLiveData<MyTable?>().apply { value = null }

    val listMyTable: LiveData<List<MyTable>> = _listMyTable
    val insertSuccess: LiveData<Boolean> = _insertSuccess
    val selectedItem: LiveData<MyTable?> = _selectedItem

    fun loadData(context: Context) {
        val repository = MyTableRepositories(MyDatabase.getInstance(context))
        viewModelScope.launch {
            _listMyTable.value = repository.getAll()
        }
    }

    fun insertData(context: Context, myTable: MyTable) {
        val repository = MyTableRepositories(MyDatabase.getInstance(context))
        viewModelScope.launch {
            repository.insert(myTable)
            _insertSuccess.value = true
        }
    }

    fun updateData(context: Context, myTable: MyTable) {
        val repository = MyTableRepositories(MyDatabase.getInstance(context))
        viewModelScope.launch {
            repository.update(myTable)
            _listMyTable.value = repository.getAll()
        }
    }

    fun deleteData(context: Context, myTable: MyTable) {
        val repository = MyTableRepositories(MyDatabase.getInstance(context))
        viewModelScope.launch {
            repository.delete(myTable)
            _listMyTable.value = repository.getAll()
        }
    }

    fun setInsertSuccess(value: Boolean) {
        _insertSuccess.value = value
    }

    fun setSelectedItem(item: MyTable?) {
        _selectedItem.value = item
    }
}
