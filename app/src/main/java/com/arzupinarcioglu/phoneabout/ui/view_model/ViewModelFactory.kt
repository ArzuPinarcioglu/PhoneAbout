package com.arzupinarcioglu.phoneabout.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner


/*
* @author Arzu Pınarcıoğlu
*/
class ViewModelFactory() :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return super.create(modelClass)
    }
}

fun <T : ViewModel> ViewModelStoreOwner.initViewModel(viewModel: Class<T>):T  = ViewModelProvider(this,
    ViewModelFactory()
).get(viewModel)