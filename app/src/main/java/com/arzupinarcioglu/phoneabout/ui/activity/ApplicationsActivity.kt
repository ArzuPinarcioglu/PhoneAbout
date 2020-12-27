package com.arzupinarcioglu.phoneabout.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arzupinarcioglu.phoneabout.databinding.ActivityListingBinding
import com.arzupinarcioglu.phoneabout.ui.CellClickListener
import com.arzupinarcioglu.phoneabout.ui.adapter.ApplicationsAdapter
import com.arzupinarcioglu.phoneabout.ui.view_model.ApplicationViewModel
import com.arzupinarcioglu.phoneabout.ui.view_model.initViewModel

class ApplicationsActivity : AppCompatActivity(),
    CellClickListener {

    lateinit var binding: ActivityListingBinding

    private val mViewModel by lazy {
        initViewModel(ApplicationViewModel::class.java)
    }

    private val mAdapter by lazy {
        ApplicationsAdapter(mViewModel.getInstalledApplications().value as List<*>, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = mAdapter

    }

    override fun onCellClickListener(packageName: String) {
        val intent = Intent(this, ApplicationDetailsActivity::class.java)
        intent.putExtra("packageName", packageName)
        startActivity(intent)

    }
}
