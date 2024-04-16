package com.fanxing.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fanxing.testapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


    }

}