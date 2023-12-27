package com.islamzada.productslistapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.islamzada.productslistapp.entity.Product

//DAO - Data Access Object
//CRUD - Create; Read; Update; Delete
@Dao
interface  ProductDao {

    @Insert
    suspend fun insert(product: Product)

    @Query("SELECT * FROM product")
    fun getAll() : LiveData<List<Product>>

    @Delete
    suspend fun delete(product: Product)

}