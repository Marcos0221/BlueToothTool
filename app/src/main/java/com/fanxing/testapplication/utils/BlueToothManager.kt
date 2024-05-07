package com.fanxing.testapplication.utils

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.fanxing.testapplication.boardcast.SearchDevices

class BlueToothManager(private val context: Context, private val bluetoothAdapter: BluetoothAdapter) {

    private val TAG:String = "BlueToothManager"

    private val DEBUG: Boolean = true
    val search: SearchDevices = SearchDevices().getInstance()

    fun getBlueToothDeviceList(): ArrayList<String> {
        Log.i(TAG, "getBlueToothDeviceList: ${search.DeviceList.toString()}")
        return search.DeviceList
    }

    /**
     * 扫描蓝牙设备
     */
    @SuppressLint("MissingPermission")
    fun ScanBlueToothDeviceList() {
        val statusCode = getBlueToothStatus()
        if (statusCode == -1){
            Toast.makeText(context, "当前设备不支持蓝牙", Toast.LENGTH_SHORT).show()
        }else if (statusCode == 0){
            Toast.makeText(context, "蓝牙已关闭，请手动打开蓝牙", Toast.LENGTH_SHORT).show()
        }else{
            if (bluetoothAdapter.isDiscovering) {
                bluetoothAdapter.cancelDiscovery()
            }
            bluetoothAdapter.startDiscovery()
            Toast.makeText(context, "开始扫描", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * @return -1: 当前设备不支持蓝牙; 0: 未开启蓝牙; 1: 已开启蓝牙;
     */
    fun getBlueToothStatus(): Int{
        if (!bluetoothAdapter.isEnabled) {
            // 蓝牙未开启
            if (DEBUG) println("蓝牙未开启")
            return 0
        }
        return 1
    }

}