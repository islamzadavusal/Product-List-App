package com.islamzada.productslistapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.islamzada.productslistapp.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel  @Inject constructor () : ViewModel() {
    val name = MutableLiveData<String>()
    val code = MutableLiveData<String>()
    val desc = MutableLiveData<String>()
}