package com.islamzada.productslistapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddPostViewModel: ViewModel() {

    val name = MutableLiveData<String>()
    val code = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    fun isInputValid(): Boolean {
        val name = name.value.orEmpty()
        val code = code.value.orEmpty()
        val description = description.value.orEmpty()

        return name.isNotEmpty() && code.isNotEmpty() && description.isNotEmpty()
    }

}