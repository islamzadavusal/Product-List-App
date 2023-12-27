package com.islamzada.productslistapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.islamzada.productslistapp.entity.Product
import com.islamzada.productslistapp.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    lateinit  var productRepository: ProductRepository

//    var addProductObserver = MutableLiveData<Boolean>()
//
//    fun onAddNewProduct(){
//        addProductObserver.postValue(true)
//    }

    fun getAllData(): LiveData<List<Product>> {
        return productRepository.getAll()
    }

    fun delete(product: Product) {
        viewModelScope.launch {
            productRepository.delete(product)
        }
    }

}
