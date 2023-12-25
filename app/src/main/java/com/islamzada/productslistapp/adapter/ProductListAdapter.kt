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

class ProductListAdapter(val context: Context, private var productList: MutableList<Product>, var onClick: (Product) -> Unit) : BaseAdapter() {

    fun addNewItem(aProduct: Product) {
        productList.add(aProduct)
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

        val holder : ViewHolder

        if (convertView == null) {
            val binding: ListItemProductBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.list_item_product,
                parent,
                false
            )

            newConvertView = binding.root
            holder = ViewHolder(binding, onClick)
            holder.bind(productList[position])

            newConvertView?.tag = holder

            return binding.root

        } else {
            holder = convertView.tag as ViewHolder
            holder.bind(productList[position])
        }

        return newConvertView!!
    }

    private class ViewHolder(var binding: ListItemProductBinding, var onClick: (Product) -> Unit) {
        fun bind(product: Product){

            binding.productName.text = product.name
            binding.productCode.text = product.code.toString()
            binding.productDetail.text = product.desc

            binding.product = product

            binding.root.setOnClickListener {
                onClick(binding.product as Product)


            }
        }
    }

}