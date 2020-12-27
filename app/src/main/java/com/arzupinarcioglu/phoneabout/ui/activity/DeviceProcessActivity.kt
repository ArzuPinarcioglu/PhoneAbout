package com.arzupinarcioglu.phoneabout.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arzupinarcioglu.phoneabout.R
import com.arzupinarcioglu.phoneabout.ui.view_model.DeviceProcessViewModel
import com.arzupinarcioglu.phoneabout.ui.view_model.initViewModel
import kotlinx.android.synthetic.main.activity_device_process.*


class DeviceProcessActivity : AppCompatActivity() {

    private val mViewModel by lazy {
        initViewModel(DeviceProcessViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_process)
        process.text = mViewModel.getRunningAppProcess(applicationContext)
    }
}