package com.islamzada.productslistapp.di

import android.content.Context
import androidx.room.Insert
import androidx.room.Room
import androidx.room.RoomDatabase
import com.islamzada.productslistapp.dao.ProductDao
import com.islamzada.productslistapp.database.AppDatabase
import com.islamzada.productslistapp.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProductDao(db: AppDatabase) : ProductDao {
        return db.productDao()

    }

    @Provides
    @Singleton
    fun provideAppDatabase (@ApplicationContext context: Context) : AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "product").build()
    }
}