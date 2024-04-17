package com.fanxing.testapplication.utils

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context

class BlueToothManager(private val context: Context, private val bluetoothAdapter: BluetoothAdapter) {

    private val DEBUG: Boolean = true

    /**
     * 扫描蓝牙设备
     */
    @SuppressLint("MissingPermission")
    fun ScanBlueToothDeviceList() {
        if (bluetoothAdapter.isDiscovering) {
            bluetoothAdapter.cancelDiscovery()
        }
        bluetoothAdapter.startDiscovery()
    }

    /**
     * @return -1: 当前设备不支持蓝牙; 0: 未开启蓝牙; 1: 已开启蓝牙;
     */
    fun getBlueToothStatus(): Int{
        if (bluetoothAdapter == null){
            // 设备不支持蓝牙
            if (DEBUG) println("设备不支持蓝牙")
            return -1
        }
        if (!bluetoothAdapter.isEnabled) {
            // 蓝牙未开启
            if (DEBUG) println("蓝牙未开启")
            return 0
        }
        return 1
    }

}