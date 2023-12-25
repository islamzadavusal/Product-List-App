package com.islamzada.productslistapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.islamzada.productslistapp.databinding.FragmentAddProductBinding

import com.islamzada.productslistapp.entity.Product
import com.islamzada.productslistapp.viewModels.AddPostViewModel

class AddProductFragment : Fragment() {
    private lateinit var binding: FragmentAddProductBinding
    private lateinit var viewModel: AddPostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddProductBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[AddPostViewModel::class.java]
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        observeAll()
    }

    private fun observeAll() {
        viewModel.newProductCallBack.observe(viewLifecycleOwner) {
            val bundle = Bundle()
            val product = Product(
                viewModel.name.value.orEmpty(),
                viewModel.code.value.orEmpty().toInt(),
                viewModel.description.value.orEmpty()
            )
            bundle.putParcelable("product", product)

            parentFragmentManager.setFragmentResult("newProduct", bundle)
            Toast.makeText(requireContext(), "Product added", Toast.LENGTH_SHORT).show()
        }

        viewModel.error.observe(viewLifecycleOwner) {
            if (!it.isNullOrEmpty()) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}