package com.fanxing.testapplication

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BlueToothDeviceListAdapter(private val context: Context): RecyclerView.Adapter<BlueToothDeviceListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BlueToothDeviceListViewHolder {
        var itemView = View.inflate(context, R.layout.item_list, null)
        var viewHolder = BlueToothDeviceListViewHolder(itemView)
        return viewHolder
    }

    override fun onBindViewHolder(holder: BlueToothDeviceListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}