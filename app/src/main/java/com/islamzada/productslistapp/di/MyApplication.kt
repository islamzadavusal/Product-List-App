package com.islamzada.productslistapp.di

import android.app.Application
import com.islamzada.productslistapp.database.AppDatabase
import com.islamzada.productslistapp.repository.ProductRepository

class MyApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { ProductRepository(database.productDao()) }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}