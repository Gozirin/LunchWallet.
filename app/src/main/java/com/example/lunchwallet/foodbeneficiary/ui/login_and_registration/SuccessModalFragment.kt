package com.example.lunchwallet.foodbeneficiary.ui.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentLoginBinding
import com.example.lunchwallet.databinding.FragmentSuccessModalBinding

class SuccessModalFragment : Fragment(R.layout.fragment_success_modal) {

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
