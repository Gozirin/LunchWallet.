package com.example.lunchwallet.foodbeneficiary.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentResetPasswordBinding

class ResetPasswordFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentResetPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resetPasswordFragmentButtonFoodBeneficiary.setOnClickListener {
//            findNavController().navigate(R.id.action_resetPasswordFragment_to_checkMailResetPasswordFragment)
        }
    }
}
