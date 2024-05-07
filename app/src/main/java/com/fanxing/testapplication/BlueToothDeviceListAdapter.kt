package com.fanxing.testapplication

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BlueToothDeviceListAdapter(private val context: Context, private val list: ArrayList<BlueToothDeviceItem>): RecyclerView.Adapter<BlueToothDeviceListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BlueToothDeviceListViewHolder {
        var itemView = View.inflate(context, R.layout.item_list, null)
        var viewHolder = BlueToothDeviceListViewHolder(itemView)
        return viewHolder
    }

    override fun onBindViewHolder(holder: BlueToothDeviceListViewHolder, position: Int) {
        val itemView = list[position]
        holder.TitleView.text = itemView.title
        holder.AddressView.text = itemView.address
    }

    override fun getItemCount(): Int {
        return list.size
    }

}