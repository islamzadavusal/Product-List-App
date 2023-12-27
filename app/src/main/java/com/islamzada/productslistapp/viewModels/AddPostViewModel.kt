package com.islamzada.productslistapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.islamzada.productslistapp.entity.Product
import com.islamzada.productslistapp.repository.ProductRepository
import kotlinx.coroutines.launch

class AddPostViewModel: ViewModel() {

    val name = MutableLiveData<String>()
    val code = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    lateinit  var productRepository: ProductRepository

    fun isInputValid(): Boolean {
        val name = name.value.orEmpty()
        val code = code.value.orEmpty()
        val description = description.value.orEmpty()

        return name.isNotEmpty() && code.isNotEmpty() && description.isNotEmpty()
    }

    fun insert(product: Product) {
        viewModelScope.launch {
            productRepository.insert(product)
        }
    }

}