package com.example.lunchwallet.foodbeneficiary.ui.login_and_registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentCheckMailPasswordBinding

class CheckMailResetPasswordFragment : Fragment(R.layout.fragment_check_mail_password) {

    private var _binding: FragmentCheckMailPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCheckMailPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.checkmailPasswordFragmentButtonFoodBeneficiary.setOnClickListener { findNavController().navigate(R.id.action_checkMailResetPasswordFragment_to_createNewPasswordFragment)
        }
    }
}
