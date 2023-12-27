package com.islamzada.productslistapp.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Product (
    @PrimaryKey (autoGenerate = true) val id: Int,
    @ColumnInfo (name = "name") val name: String,
    @ColumnInfo (name = "code") val code : Int,
    @ColumnInfo (name = "desc") val desc: String) : Parcelable {
}