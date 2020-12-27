package com.arzupinarcioglu.phoneabout.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arzupinarcioglu.phoneabout.R
import com.arzupinarcioglu.phoneabout.ui.activity.ApplicationsActivity
import com.arzupinarcioglu.phoneabout.ui.activity.DeviceFeaturesActivity
import com.arzupinarcioglu.phoneabout.ui.activity.DeviceProcessActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.packageManager = packageManager
        var intent: Intent
        button_device_features.setOnClickListener(){
            intent = Intent(this, DeviceFeaturesActivity::class.java)
            startActivity(intent)
        }
        button_applications.setOnClickListener(){
            intent = Intent(this, DeviceFeaturesActivity::class.java)
            startActivity(intent)
        }
        button_applications.setOnClickListener(){
            intent = Intent(this, ApplicationsActivity::class.java)
            startActivity(intent)
        }
        button_process.setOnClickListener(){
            intent = Intent(this, DeviceProcessActivity::class.java)
            startActivity(intent)
        }


    }
}
