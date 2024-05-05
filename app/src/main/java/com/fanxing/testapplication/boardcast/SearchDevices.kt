package com.fanxing.testapplication.boardcast

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.DebugUtils
import android.util.Log

class SearchDevices: BroadcastReceiver() {
    
    private val TAG: String = "SearchDevices"
    var DeviceList: ArrayList<String> = ArrayList()

    fun getInstance(): SearchDevices {
        return this
    }

    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            BluetoothAdapter.ACTION_STATE_CHANGED -> {
                Log.i(TAG, "onReceive: ACTION_STATE_CHANGED")
            }
            BluetoothAdapter.ACTION_DISCOVERY_FINISHED -> {
                Log.i(TAG, "onReceive: 扫描完成")
            }
            BluetoothAdapter.ACTION_DISCOVERY_STARTED -> {
                Log.i(TAG, "onReceive: 开始扫描")
            }
            BluetoothDevice.ACTION_FOUND -> {
                var device: BluetoothDevice? = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                val str = device?.name + "|" + device?.address
                if (DeviceList.indexOf(str) == -1){
                    if(device?.name!=null){
                        Log.i(TAG, "onReceive: $str")
                    }
                }
            }
        }
    }
}