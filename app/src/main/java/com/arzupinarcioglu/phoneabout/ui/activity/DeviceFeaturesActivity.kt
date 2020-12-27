package com.arzupinarcioglu.phoneabout.ui.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.arzupinarcioglu.phoneabout.R

class DeviceFeaturesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_features)
        val details = """
            VERSION.RELEASE : ${Build.VERSION.RELEASE}
            VERSION.INCREMENTAL : ${Build.VERSION.INCREMENTAL}
            VERSION.SDK.NUMBER : ${Build.VERSION.SDK_INT}
            BOARD : ${Build.BOARD}
            BOOTLOADER : ${Build.BOOTLOADER}
            BRAND : ${Build.BRAND}
            DISPLAY : ${Build.DISPLAY}
            FINGERPRINT : ${Build.FINGERPRINT}
            HARDWARE : ${Build.HARDWARE}
            HOST : ${Build.HOST}
            ID : ${Build.ID}
            MANUFACTURER : ${Build.MANUFACTURER}
            MODEL : ${Build.MODEL}
            PRODUCT : ${Build.PRODUCT}
            TAGS : ${Build.TAGS}
            TIME : ${Build.TIME}
            TYPE : ${Build.TYPE}
            UNKNOWN : ${Build.UNKNOWN}
            USER : ${Build.USER}
            """.trimIndent()

        var detailsTextView = findViewById<TextView>(R.id.details)
        detailsTextView.setText(details)
    }
}