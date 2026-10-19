package com.example.roomtutorial

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomtutorial.database.entities.MyTable

class InsertRecordFragment : Fragment() {

    private lateinit var viewModel: MainActivityData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_insert_record, container, false)
        val tvTitle: TextView = rootView.findViewById(R.id.tvTitle)
        val edtName: EditText = rootView.findViewById(R.id.edtName)
        val edtDOB: EditText = rootView.findViewById(R.id.edtDOB)
        val btnUpdate: Button = rootView.findViewById(R.id.btnUpdate)
        val btnInsert: Button = rootView.findViewById(R.id.btnInsertRecord)

        viewModel = ViewModelProvider(requireActivity())[MainActivityData::class.java]

        // Insert mode (default) or update mode (a record was chosen in the list)
        val selected = viewModel.selectedItem.value
        if (selected == null) {
            tvTitle.text = getString(R.string.insert_record_title)
            btnUpdate.isEnabled = false
        } else {
            tvTitle.text = getString(R.string.update_record_title)
            edtName.setText(selected.name)
            edtDOB.setText(selected.dateOfBirth)
            btnInsert.isEnabled = false
        }

        btnInsert.setOnClickListener {
            val name = edtName.text.toString().trim()
            if (name.isEmpty()) {
                Toast.makeText(requireContext(), R.string.name_required, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val data = MyTable(name, edtDOB.text.toString().trim())
            insertData(viewModel, requireContext(), data)
        }

        btnUpdate.setOnClickListener {
            val item = viewModel.selectedItem.value ?: return@setOnClickListener
            val name = edtName.text.toString().trim()
            if (name.isEmpty()) {
                Toast.makeText(requireContext(), R.string.name_required, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Same object => same primary key, so Room updates that row
            item.name = name
            item.dateOfBirth = edtDOB.text.toString().trim()
            viewModel.updateData(requireContext(), item)
            viewModel.setSelectedItem(null)
            Toast.makeText(requireContext(), R.string.record_updated, Toast.LENGTH_SHORT).show()
            (requireActivity() as MainActivity).loadViewFragment()
        }

        // Insert finished -> confirm and clear the form
        viewModel.insertSuccess.observe(viewLifecycleOwner, Observer { success ->
            if (success) {
                Toast.makeText(requireContext(), R.string.record_inserted, Toast.LENGTH_SHORT).show()
                edtName.text.clear()
                edtDOB.text.clear()
                viewModel.setInsertSuccess(false)
            }
        })

        return rootView
    }

    private fun insertData(viewModel: MainActivityData, context: Context, myTable: MyTable) {
        try {
            viewModel.insertData(context, myTable)
        } catch (e: Exception) {
            Toast.makeText(context, R.string.save_failed, Toast.LENGTH_SHORT).show()
        }
    }
}
