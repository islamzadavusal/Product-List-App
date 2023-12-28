package com.islamzada.productslistapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.islamzada.productslistapp.entity.Product
import com.islamzada.productslistapp.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor (var repository: ProductRepository): ViewModel() {

//    lateinit  var productRepository: ProductRepository

//    var addProductObserver = MutableLiveData<Boolean>()
//
//    fun onAddNewProduct(){
//        addProductObserver.postValue(true)
//    }

    fun getAllData(): LiveData<List<Product>> {
        return repository.getAll()
    }

    fun delete(product: Product) {
        viewModelScope.launch {
            repository.delete(product)
        }
    }

}
