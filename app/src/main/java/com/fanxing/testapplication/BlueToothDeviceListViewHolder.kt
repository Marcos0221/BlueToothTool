package com.fanxing.testapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BlueToothDeviceListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    var TitleView: TextView
    var AddressView: TextView

    init {
        TitleView=itemView.findViewById(R.id.item_title)
        AddressView=itemView.findViewById(R.id.item_address)
    }

}