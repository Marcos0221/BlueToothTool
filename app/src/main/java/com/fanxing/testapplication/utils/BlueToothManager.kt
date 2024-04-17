package com.fanxing.testapplication.utils

import android.bluetooth.BluetoothAdapter

class BlueToothManager {

    private val DEBUG: Boolean = true

    /**
     * @return -1: 当前设备不支持蓝牙
     */
    fun getBlueToothStatus(): Int{
        val blueToothAdapter = BluetoothAdapter.getDefaultAdapter()
        if (blueToothAdapter == null){
            // 设备不支持蓝牙
            if (DEBUG) println("设备不支持蓝牙")
            return -1
        }
        if (!blueToothAdapter.isEnabled) {
            // 蓝牙未开启
            if (DEBUG) println("蓝牙未开启")
            return 0
        }
        return 1
    }

}