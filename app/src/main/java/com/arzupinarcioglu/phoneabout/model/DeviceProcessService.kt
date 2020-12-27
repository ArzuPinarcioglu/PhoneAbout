package com.arzupinarcioglu.phoneabout.model

import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo
import android.content.Context


class DeviceProcessService {

    fun getRunningAppProcess(context: Context): String{
        var response =""
        val RAP: List<RunningAppProcessInfo> = (context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager).runningAppProcesses
        for( processInfo in  RAP ){
            response += processInfo.processName + "\n"

        }
        return response
    }

    companion object {

        private val TAG = "DeviceProcessService"
    }
}
