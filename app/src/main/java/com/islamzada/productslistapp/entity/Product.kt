package com.islamzada.productslistapp.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product (val name: String,
                    val code : Int,
                    val desc: String) : Parcelable {
}