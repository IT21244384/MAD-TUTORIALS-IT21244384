package com.example.roomtutorial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomtutorial.database.entities.MyTable

/**
 * Shows one row per record. The Update / Delete buttons report back through the
 * [onUpdate] / [onDelete] callbacks (handleUpdate / handleDelete in the sheet).
 */
class MyDataAdapter(
    val data: List<MyTable>,
    private val onUpdate: (MyTable) -> Unit,
    private val onDelete: (MyTable) -> Unit
) : RecyclerView.Adapter<MyDataVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDataVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_layout, parent, false)
        return MyDataVH(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyDataVH, position: Int) {
        val singleData = data[position]
        holder.tvItemName.text = "${singleData.name}  (${singleData.dateOfBirth})"
        holder.btnUpdateItem.setOnClickListener {
            handleUpdate(singleData)
        }
        holder.btnDeleteItem.setOnClickListener {
            handleDelete(singleData)
        }
    }

    private fun handleUpdate(item: MyTable) {
        onUpdate(item)
    }

    private fun handleDelete(item: MyTable) {
        onDelete(item)
    }
}
