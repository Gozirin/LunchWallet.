package com.example.lunchwallet.kitchenstaff.forgotpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentKitchenStaffResetPasswordBinding
import com.example.lunchwallet.util.ResetPasswordInputValidations.ResetPasswordValidation


class KitchenStaffResetPassword : Fragment() {
    private var _binding: FragmentKitchenStaffResetPasswordBinding? = null
    private val binding get() = _binding!!

    private lateinit var errorMsg: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentKitchenStaffResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        errorMsg = binding.kitchenstaffResetPasswordErrorMsg
        emailFocusListener()

        // Reset_Password To CheckMailPassword
        binding.kitchenstaffResetPasswordFragmentButton.setOnClickListener {
            onClickResetButton()
        }
    }

    private fun emailFocusListener() {
        binding.kitchenstaffResetPasswordFragmentET.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.kitchenstaffResetPasswordFragmentTiI.helperText =
                    ResetPasswordValidation.validateEmail(binding.kitchenstaffResetPasswordFragmentET.text.toString())
        }
    }

    private fun onClickResetButton() {
        binding.kitchenstaffResetPasswordFragmentTiI.helperText =
            ResetPasswordValidation.validateEmail(binding.kitchenstaffResetPasswordFragmentET.text.toString())

        val validEmailInput = ResetPasswordValidation.validateEmail(binding.kitchenstaffResetPasswordFragmentET.text.toString()) == null
        if (validEmailInput){
            findNavController().navigate(R.id.action_resetPasswordFragment_to_checkMailResetPasswordFragment)
        } else {
            binding.kitchenstaffResetPasswordFragmentTiI.helperText.toString()
        }
    }
}