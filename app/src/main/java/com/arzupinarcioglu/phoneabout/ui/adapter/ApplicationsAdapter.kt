package com.arzupinarcioglu.phoneabout.ui.adapter


import android.content.pm.PackageInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arzupinarcioglu.phoneabout.R
import com.arzupinarcioglu.phoneabout.ui.CellClickListener
import kotlinx.android.synthetic.main.row_list_item.view.*


class ApplicationsAdapter(val applications: List<*>,
                          private val cellClickListener: CellClickListener) :
    RecyclerView.Adapter<ApplicationsAdapter.ApplicationsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicationsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_list_item, parent, false)
        return ApplicationsViewHolder(v)
    }

    override fun getItemCount(): Int {
        return applications.size
    }

    override fun onBindViewHolder(holder: ApplicationsViewHolder, position: Int) {

        val application = applications[position] as PackageInfo
        holder.itemView.packageName.text = application.packageName
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(application.packageName)
        }
    }
    class ApplicationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}