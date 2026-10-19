package com.example.roomtutorial

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private val insertRecordFragment = InsertRecordFragment()
    private val viewRecordsFragment = ViewRecordsFragment()
    lateinit var btnAdd: Button
    lateinit var btnView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[MainActivityData::class.java]

        btnAdd = findViewById(R.id.btnAdd)
        btnView = findViewById(R.id.btnView)

        btnAdd.setOnClickListener {
            // "Add Record" always starts a fresh insert, not an edit
            viewModel.setSelectedItem(null)
            loadInsertFragment()
        }
        btnView.setOnClickListener {
            loadViewFragment()
        }
    }

    // Public so fragments can navigate (e.g. Update button in the list)
    fun loadInsertFragment() {
        val fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, insertRecordFragment).commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, insertRecordFragment).commit()
        }
    }

    fun loadViewFragment() {
        val fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, viewRecordsFragment).commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, viewRecordsFragment).commit()
        }
    }
}
