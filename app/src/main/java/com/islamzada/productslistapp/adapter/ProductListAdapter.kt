package com.islamzada.productslistapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.islamzada.productslistapp.R
import com.islamzada.productslistapp.databinding.ListItemProductBinding
import com.islamzada.productslistapp.entity.Product

class ProductListAdapter(val context: Context, private var productList: MutableList<Product>, var onClick: (Product) -> Unit, var onDeleteClick: (Product) -> Unit
) : BaseAdapter() {

    fun addNewItem(newProductList: List<Product>) {
        // Mevcut ürün listesini temizle ve yeni ürünleri ekleyerek güncelle
        productList.clear()
        productList.addAll(newProductList)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return productList.count()
    }

    override fun getItem(position: Int): Any {
        return productList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var newConvertView = convertView
        val holder: ViewHolder

        // convertView null ise, yeni bir View oluştur ve bağla
        if (convertView == null) {
            val binding: ListItemProductBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.list_item_product,
                parent,
                false
            )

            // ViewHolder nesnesi oluştur ve binding ile tanımla
            newConvertView = binding.root
            holder = ViewHolder(binding, onClick, onDeleteClick)
            holder.bind(productList[position])

            // ViewHolder nesnesini yeni View'in tag özelliğine tanımla
            newConvertView.tag = holder
        } else {
            // convertView null değilse, ViewHolder nesnesini elde et
            holder = convertView.tag as ViewHolder
            // ViewHolder'i mevcut ürünle birleştir
            holder.bind(productList[position])
        }

        return newConvertView!!
    }

    // ViewHolder sınıfı - her bir ürünü görüntülemek için kullanılan sınıf
    private class ViewHolder(
        var binding: ListItemProductBinding,
        var onClick: (Product) -> Unit,
        var onDeleteClick: (Product) -> Unit
    ) {
        // ViewHolder'i belirtilen ürünle birleştirmek için kullanılan fonksiyon
        fun bind(product: Product) {
            binding.productName.text = "Name: ${product.name}"
            binding.productCode.text = "Code: ${product.code}"
            binding.productDetail.text = "Description: ${product.desc}"

            binding.product = product

            binding.root.setOnClickListener {
                onClick(binding.product as Product)
            }

            binding.deleteButton.setOnClickListener {
                onDeleteClick(binding.product as Product)
            }
        }
    }
}