package com.example.lunchwallet.foodbeneficiary.ui.resetpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentSuccessModalBinding

class SuccessModalFragment : DialogFragment(){

    private var _binding: FragmentSuccessModalBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuccessModalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.successModalFragmentPasswordSuccess.setOnClickListener {
            findNavController().navigate(R.id.successModalFragment)
        }
    }
}
