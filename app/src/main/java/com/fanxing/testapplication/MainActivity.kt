package com.fanxing.testapplication

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.IntentFilter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.fanxing.testapplication.boardcast.SearchDevices
import com.fanxing.testapplication.databinding.ActivityMainBinding
import com.fanxing.testapplication.utils.BlueToothManager
import com.scwang.smart.refresh.header.MaterialHeader

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var context: Context
    private lateinit var searchDevices: SearchDevices
    private lateinit var blueToothManager: BlueToothManager
    private lateinit var bluetoothAdapter: BluetoothAdapter

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        context = viewBinding.root.context
        setContentView(viewBinding.root)
        init()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(1, 1, 1, "扫描蓝牙设备")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            // 扫描蓝牙设备
            1 -> blueToothManager.ScanBlueToothDeviceList()
        }
        return true
    }

    private fun init(){
        searchDevices= SearchDevices()
        bluetoothAdapter = (getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter
        blueToothManager= BlueToothManager(this, bluetoothAdapter)
        val intentFilter = IntentFilter()
        intentFilter.apply {
            addAction(BluetoothDevice.ACTION_FOUND)
            addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED)
            addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)
            addAction(BluetoothAdapter.ACTION_STATE_CHANGED)
            priority = IntentFilter.SYSTEM_HIGH_PRIORITY
        }
        registerReceiver(searchDevices, intentFilter)
    }
}
