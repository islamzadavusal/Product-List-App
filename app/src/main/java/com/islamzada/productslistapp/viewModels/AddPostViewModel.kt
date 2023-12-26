package com.islamzada.productslistapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddPostViewModel: ViewModel() {

    val name = MutableLiveData<String>()
    val code = MutableLiveData<String>()
    val description = MutableLiveData<String>()

}