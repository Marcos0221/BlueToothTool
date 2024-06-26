package com.fanxing.testapplication

import android.bluetooth.BluetoothManager
import android.content.Context
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.fanxing.testapplication.utils.BlueToothManager

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun scanBlueDevices() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val bluetoothAdapter = (appContext.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter
        if (bluetoothAdapter.isDiscovering) {
            bluetoothAdapter.cancelDiscovery()
        }
        bluetoothAdapter.startDiscovery()
    }

    @Test
    fun useAppContext() {
        val TAG: String = "蓝牙设备状态测试"
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val bluetoothAdapter = (appContext.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter
        val blueToothManager = BlueToothManager(appContext, bluetoothAdapter)
        var blueToothStatus = blueToothManager.getBlueToothStatus()

            if (blueToothStatus == -1) {
                Log.i(TAG, "useAppContext: 当前设备不支持蓝牙")
            } else if (blueToothStatus == 0) {
                Log.i(TAG, "useAppContext: 蓝牙未开启")
            } else {
                Log.i(TAG, "useAppContext: 蓝牙已开启")
            }
    }
}