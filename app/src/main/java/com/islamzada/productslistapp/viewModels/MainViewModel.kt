package com.islamzada.productslistapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var addProductObserver = MutableLiveData<Boolean>()

    fun onAddNewProduct(){
        addProductObserver.postValue(true)
    }

}
