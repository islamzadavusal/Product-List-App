package com.islamzada.productslistapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.islamzada.productslistapp.R
import com.islamzada.productslistapp.databinding.FragmentDetailsBinding
import com.islamzada.productslistapp.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSettingBinding.inflate(inflater)

        binding.button2.setOnClickListener {
            requireActivity().finish()
        }

        return  binding.root


    }

}