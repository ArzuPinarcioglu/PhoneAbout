package com.arzupinarcioglu.phoneabout.ui

import android.app.Application
import android.content.pm.PackageManager


class App : Application() {

    companion object {
        lateinit var packageManager: PackageManager
    }

}