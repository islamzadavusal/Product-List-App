package com.islamzada.productslistapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.islamzada.productslistapp.R
import com.islamzada.productslistapp.adapter.ProductListAdapter
import com.islamzada.productslistapp.databinding.FragmentMainBinding
import com.islamzada.productslistapp.entity.Product
import com.islamzada.productslistapp.viewModels.MainViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: ProductListAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding = FragmentMainBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        adapter = ProductListAdapter(requireContext(), mutableListOf()) {
        }

        binding.productList.adapter = adapter

        parentFragmentManager.setFragmentResultListener("newProduct", viewLifecycleOwner) { _, bundle ->
            val newProduct = bundle.getParcelable<Product>("product")
            newProduct?.let {
                viewModel.onAddNewProduct()
                adapter.addNewItem(it)
            }
        }

        return binding.root
    }

}
