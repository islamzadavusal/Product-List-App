package com.islamzada.productslistapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.islamzada.productslistapp.R
import com.islamzada.productslistapp.adapter.ProductListAdapter
import com.islamzada.productslistapp.databinding.FragmentMainBinding
import com.islamzada.productslistapp.di.MyApplication
import com.islamzada.productslistapp.entity.Product
import com.islamzada.productslistapp.viewModels.MainViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: ProductListAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.productRepository = (activity?.application as MyApplication).repository

        binding = FragmentMainBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        // ProductListAdapter nesnesini oluşturun ve ayarlayın
        adapter = ProductListAdapter(requireContext(), mutableListOf(),

            // "onClick" fonksiyonu: Listeden bir ürün seçtiğimizde DetaylarFragment'e geç
            onClick = { product ->
                val detailsFragment = DetailsFragment()

                val bundle = Bundle().apply {
                    putString("name", product.name)
                    putInt("code", product.code)
                    putString("desc", product.desc)
                }

                detailsFragment.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.navHost, detailsFragment)
                    .addToBackStack(null)
                    .commit()
            },

            // "onDeleteClick" fonksiyonu: Listedeki bir öğeyi sil
            onDeleteClick = { product ->
                viewModel.delete(product)
            }
        )

        binding.productList.adapter = adapter

        // ViewModel'den LiveData nesnesini alın ve nesneyi  obzerv etmek
        viewModel.getAllData().observe(viewLifecycleOwner, Observer { productList ->
            // Adaptöre yeni ürünler eklemek ve listeyi güncellemek
            adapter.addNewItem(productList)
        })

        return binding.root
    }
}
