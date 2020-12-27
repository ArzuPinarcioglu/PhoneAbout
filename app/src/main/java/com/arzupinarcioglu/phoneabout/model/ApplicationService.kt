package com.arzupinarcioglu.phoneabout.model

import android.content.Context
import android.content.pm.PackageManager
import android.content.res.AssetManager
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.arzupinarcioglu.phoneabout.ui.App.Companion.packageManager
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException

/*
* @author Arzu Pınarcıoğlu
*/
class ApplicationService {
    fun getInstalledApplications(): MutableLiveData<List<*>> {
        val mutableLiveData = MutableLiveData<List<*>>()
        mutableLiveData.value = packageManager.getInstalledPackages(0)
        return mutableLiveData
    }

    fun getApplicationIntent(packageName: String): String{
        val activities = packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES).activities
        return if(activities == null ) "" else activities.joinToString (separator = "\n"){ it.name }
    }

    fun getApplicationPermissions(packageName: String): String{
        val requestedPermissions = packageManager.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS).requestedPermissions
        return if(requestedPermissions == null ) "" else requestedPermissions.joinToString (separator = "\n")
    }
    fun getApplicationServices(packageName: String): String{
        val services = packageManager.getPackageInfo(packageName, PackageManager.GET_SERVICES).services
        return if(services == null ) "" else services.joinToString (separator = "\n"){ it.name }
    }
    fun getApplicationReceivers(packageName: String): String{
        val receivers = packageManager.getPackageInfo(packageName, PackageManager.GET_RECEIVERS).receivers
        return if(receivers == null ) "" else receivers.joinToString (separator = "\n"){ it.name }
    }
    fun getApplicationProviders(packageName: String): String{
        val providers = packageManager.getPackageInfo(packageName, PackageManager.GET_PROVIDERS).providers
        return if(providers == null ) "" else providers.joinToString (separator = "\n"){ it.name }
    }
    fun getApplicationManifest(context: Context, packageName: String): String{
        var response =""
        try {
            val am: AssetManager = context.createPackageContext(packageName, 0).getAssets()
            val xml = am.openXmlResourceParser("AndroidManifest.xml")
            var eventType = xml.next()
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val attributeCount = xml.attributeCount
                for (i in 0 until attributeCount) {
                    response += "name=" + xml.getAttributeName(i) +
                            ": value=" +  xml.getAttributeValue(i)+ "\n"
                }
                eventType = xml.next()
            }
            xml.close()
        } catch (ignore: XmlPullParserException) {
            Log.e(TAG, ignore.message)
        }
        return response
    }
    companion object {

        private val TAG = "RepositoryService"
    }

}
