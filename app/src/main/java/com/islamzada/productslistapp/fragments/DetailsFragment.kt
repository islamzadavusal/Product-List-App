package com.islamzada.productslistapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.islamzada.productslistapp.R
import com.islamzada.productslistapp.databinding.FragmentDetailsBinding
import com.islamzada.productslistapp.viewModels.DetailsViewModel


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater)

        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]


        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val name = arguments?.getString("name")
        val code = arguments?.getInt("code", 0)
        val desc = arguments?.getString("desc")

        viewModel.name.value = "Product name: $name"
        viewModel.code.value = "Product code: $code"
        viewModel.desc.value = "Product description: $desc"

        return binding.root
    }
}
