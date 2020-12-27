package com.arzupinarcioglu.phoneabout.ui.view_model

import android.content.Context
import androidx.lifecycle.ViewModel
import com.arzupinarcioglu.phoneabout.model.DeviceProcessService

class DeviceProcessViewModel  : ViewModel(){
    private val deviceProcessService: DeviceProcessService

    fun getRunningAppProcess(context: Context): String {
        return deviceProcessService.getRunningAppProcess(context)
    }

    init {
        deviceProcessService = DeviceProcessService()
    }
}