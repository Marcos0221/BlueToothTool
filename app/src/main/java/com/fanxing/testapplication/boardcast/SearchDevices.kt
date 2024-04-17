package com.fanxing.testapplication.boardcast

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SearchDevices: BroadcastReceiver() {
    
    private val TAG: String = "SearchDevices"

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
                Log.i(TAG, "onReceive: 得到设备对象")
            }
        }
    }
}