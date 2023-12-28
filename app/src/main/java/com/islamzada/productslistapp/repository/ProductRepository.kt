package com.islamzada.productslistapp.repository

import androidx.lifecycle.LiveData
import com.islamzada.productslistapp.dao.ProductDao
import com.islamzada.productslistapp.entity.Product
import javax.inject.Inject


interface ProductRepositoryInterface {


}
class ProductRepository @Inject constructor(private val productDao : ProductDao) : ProductRepositoryInterface{
    suspend fun insert (product: Product) {
        productDao.insert(product)
    }
    fun getAll() : LiveData<List<Product>> {
        return productDao.getAll()
    }
    suspend fun delete (product: Product) {
        productDao.delete(product)
    }
}