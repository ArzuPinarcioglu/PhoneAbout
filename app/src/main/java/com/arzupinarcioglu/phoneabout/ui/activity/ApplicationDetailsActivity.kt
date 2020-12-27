package com.arzupinarcioglu.phoneabout.ui.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.arzupinarcioglu.phoneabout.R
import com.arzupinarcioglu.phoneabout.ui.view_model.ApplicationViewModel
import com.arzupinarcioglu.phoneabout.ui.view_model.initViewModel
import kotlinx.android.synthetic.main.activity_application_details.*

class ApplicationDetailsActivity : AppCompatActivity() {

    private val mViewModel by lazy {
        initViewModel(ApplicationViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application_details)
        var packageName = intent.extras?.get("packageName") as String

        package_name.text = packageName
        applications_intent.text = mViewModel.getApplicationIntent(packageName)
        applications_permissons.text = mViewModel.getApplicationPermissions(packageName)
        applications_services.text = mViewModel.getApplicationServices(packageName)
        applications_receivers.text = mViewModel.getApplicationReceivers(packageName)
        applications_providers.text = mViewModel.getApplicationProviders(packageName)
        applications_manifest.text = mViewModel.getApplicationManifest(this, packageName)

        permissions_button.setOnClickListener{
            if(applications_permissons.visibility == View.VISIBLE)
                applications_permissons.visibility = View.GONE
            else
                applications_permissons.visibility = View.VISIBLE
        }

        intents_button.setOnClickListener{
            if(applications_intent.visibility == View.VISIBLE)
                applications_intent.visibility = View.GONE
            else
                applications_intent.visibility = View.VISIBLE
        }
        services_button.setOnClickListener{
            if(applications_services.visibility == View.VISIBLE)
                applications_services.visibility = View.GONE
            else
                applications_services.visibility = View.VISIBLE
        }
        receivers_button.setOnClickListener{
            if(applications_receivers.visibility == View.VISIBLE)
                applications_receivers.visibility = View.GONE
            else
                applications_receivers.visibility = View.VISIBLE
        }
        providers_button.setOnClickListener{
            if(applications_providers.visibility == View.VISIBLE)
                applications_providers.visibility = View.GONE
            else
                applications_providers.visibility = View.VISIBLE
        }
        manifest_button.setOnClickListener{
            if(applications_manifest.visibility == View.VISIBLE)
                applications_manifest.visibility = View.GONE
            else
                applications_manifest.visibility = View.VISIBLE
        }
    }
}