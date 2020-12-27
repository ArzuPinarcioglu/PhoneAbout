package com.arzupinarcioglu.phoneabout.ui.view_model


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arzupinarcioglu.phoneabout.model.ApplicationService


class ApplicationViewModel() : ViewModel(){

    private val applicationService: ApplicationService

    fun getInstalledApplications(): LiveData<List<*>> {
        return applicationService.getInstalledApplications()
    }

    fun getApplicationIntent(packageName: String): String {
        return applicationService.getApplicationIntent(packageName)
    }
    fun getApplicationPermissions(packageName: String): String {
        return applicationService.getApplicationPermissions(packageName)
    }
    fun getApplicationServices(packageName: String): String {
        return applicationService.getApplicationServices(packageName)
    }
    fun getApplicationReceivers(packageName: String): String {
        return applicationService.getApplicationReceivers(packageName)
    }
    fun getApplicationProviders(packageName: String): String {
        return applicationService.getApplicationProviders(packageName)
    }
    fun getApplicationManifest(context: Context, packageName: String): String {
        return applicationService.getApplicationManifest(context, packageName )
    }

    init {
        applicationService = ApplicationService()
    }

}