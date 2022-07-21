package com.example.lunchwallet.foodbeneficiary.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentLoginBinding
import com.example.lunchwallet.foodbeneficiary.validations.loginvalidation.LoginInputValidation

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var errorMsg: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    // initialising Binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        errorMsg = binding.LoginErrorMsg
        emailFocusListener()
        passwordFocusListener()

        // LOGIN BUTTON
        binding.loginFragmentButtonFoodBeneficiary.setOnClickListener {
            onClickLoginButton()
        }
        // Forgot Password
        binding.loginFragmentForgotpasswordTvFoodBeneficiary.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_resetPasswordFragment)
        }
        // SIGN-UP
        binding.loginFragmentSignupTvFoodBeneficiary.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_foodBeneficiaryDashboardFragment)
        }
    }

    private fun emailFocusListener() {
        binding.loginFragmentEmailEtFoodBeneficiary.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.loginFragmentEmailTilFoodBeneficiary.helperText =
                    LoginInputValidation.validateEmail(binding.loginFragmentEmailEtFoodBeneficiary.text.toString())
        }
    }

    private fun passwordFocusListener() {
        binding.loginFragmentPasswordEtFoodBeneficiary.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.loginFragmentPasswordTilFoodBeneficiary.helperText =
                    LoginInputValidation.validatePassword(binding.loginFragmentPasswordEtFoodBeneficiary.text.toString())
        }
    }

    private fun onClickLoginButton() {
        binding.loginFragmentEmailTilFoodBeneficiary.helperText = LoginInputValidation.validateEmail(binding.loginFragmentEmailEtFoodBeneficiary.text.toString())

        binding.loginFragmentPasswordTilFoodBeneficiary.helperText = LoginInputValidation.validatePassword(binding.loginFragmentPasswordEtFoodBeneficiary.text.toString())

        val validEmailInput = LoginInputValidation.validateEmail(binding.loginFragmentEmailEtFoodBeneficiary.text.toString()) == null
        val validPasswordInput = LoginInputValidation.validatePassword(binding.loginFragmentPasswordEtFoodBeneficiary.text.toString()) == null

        if (validEmailInput && validPasswordInput) {
            findNavController().navigate(R.id.action_loginFragment_to_foodBeneficiaryDashboardFragment)
        } else {
            invalidCredentials()
        }
    }

    private fun invalidCredentials() {
        var message = ""
        if (binding.loginFragmentEmailTilFoodBeneficiary.helperText != null) {
            message = "\n\nEmail: " + binding.loginFragmentEmailTilFoodBeneficiary.helperText
        }
        if (binding.loginFragmentPasswordTilFoodBeneficiary.helperText != null) {
            message = "\n\nEmail: " + binding.loginFragmentPasswordTilFoodBeneficiary.helperText
        }
    }
}
