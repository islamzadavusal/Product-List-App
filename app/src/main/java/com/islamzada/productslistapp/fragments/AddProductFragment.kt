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

        binding.buttonOnClick.setOnClickListener {
            if (isInputValid()) {
                val bundle = Bundle()
                val product = Product(
                    viewModel.name.value.orEmpty(),
                    viewModel.code.value.orEmpty().toInt(),
                    viewModel.description.value.orEmpty()
                )
                bundle.putParcelable("product", product)

                parentFragmentManager.setFragmentResult("newProduct", bundle)
                Toast.makeText(requireContext(), "Product added", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun isInputValid(): Boolean {
        val name = viewModel.name.value.orEmpty()
        val code = viewModel.code.value.orEmpty()
        val description = viewModel.description.value.orEmpty()

        return name.isNotEmpty() && code.isNotEmpty() && description.isNotEmpty()
    }
}
