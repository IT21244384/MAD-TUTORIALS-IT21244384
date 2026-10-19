package com.example.roomtutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewRecordsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_view_records, container, false)
        val rv: RecyclerView = rootView.findViewById(R.id.rvList)
        rv.layoutManager = LinearLayoutManager(requireContext())

        val viewModel = ViewModelProvider(requireActivity())[MainActivityData::class.java]
        viewModel.loadData(requireContext())

        // viewLifecycleOwner (not the activity) so the observer is removed with this view
        viewModel.listMyTable.observe(viewLifecycleOwner, Observer {
            rv.adapter = MyDataAdapter(
                it,
                onUpdate = { item ->
                    viewModel.setSelectedItem(item)
                    (requireActivity() as MainActivity).loadInsertFragment()
                },
                onDelete = { item ->
                    viewModel.deleteData(requireContext(), item)
                    Toast.makeText(requireContext(), R.string.record_deleted, Toast.LENGTH_SHORT).show()
                }
            )
        })

        return rootView
    }
}
