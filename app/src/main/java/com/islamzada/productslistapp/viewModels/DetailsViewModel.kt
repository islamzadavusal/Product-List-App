package com.islamzada.productslistapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {
    val name = MutableLiveData<String>()
    val code = MutableLiveData<String>()
    val desc = MutableLiveData<String>()
}