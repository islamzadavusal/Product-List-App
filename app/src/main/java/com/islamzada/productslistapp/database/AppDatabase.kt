package com.islamzada.productslistapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.islamzada.productslistapp.dao.ProductDao
import com.islamzada.productslistapp.entity.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    //Instance
//    companion object {
//        private var database : AppDatabase? = null
//
//        fun getDatabase(context: Context) : AppDatabase {
//            if(database != null) {
//                return database!!
//            } else {
//                synchronized(this){
//                    database = Room.databaseBuilder(
//                        context,
//                        AppDatabase::class.java,
//                        "product").build()
//
//                    return database!!
//
//                }
//            }
//        }
//    }
}