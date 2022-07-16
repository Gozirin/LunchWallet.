package com.example.lunchwallet.foodbeneficiary.ui.login_and_registration

import android.os.Bundle
import android.preference.Preference
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentLoginBinding
import com.example.lunchwallet.foodbeneficiary.commons.Resource
import com.example.lunchwallet.foodbeneficiary.data.model.AuthModel.LoginModel
import com.example.lunchwallet.foodbeneficiary.ui.login_and_registration.Viewmodels.AuthenticationViewModel
import com.example.lunchwallet.foodbeneficiary.validations.LoginInputValidation

class LoginFragment : Fragment(R.layout.fragment_login) {
    lateinit var preference: Preference
    private val TAG = "LoginFragment"
    private lateinit var binding: FragmentLoginBinding
    private lateinit var userInfo: LoginModel
    private val viewModel: AuthenticationViewModel by viewModels()
    private lateinit var errorMsg: TextView
    private lateinit var receivedEmail: String
    private lateinit var receivedPassword: String

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
        Log.d(TAG, "onViewCreated: Login Fragment")
        binding.loginFragmentEmailEtFoodBeneficiaryTv.hint = ""
        binding.loginFragmentPasswordEtFoodBeneficiaryTv.hint = ""
        errorMsg = binding.LoginErrorMsg

        // Forgot Password Page
        binding.loginFragmentForgotpasswordFoodBeneficiaryTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_resetPasswordFragment)
        }
        // LOGIN BUTTON
        binding.loginFragmentButtonFoodBeneficiaryTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_resetPasswordFragment)
        }
        // SIGN-UP PAGE
        binding.loginFragmentSignupFoodBeneficiaryTv.setOnClickListener {
            //  findNavController().navigate(R.id.action_loginFragment_to_)
        }
        binding.loginFragmentButtonFoodBeneficiaryTv.setOnClickListener {
            receivedEmail = binding.loginFragmentEmailEtFoodBeneficiaryTv.text.toString()
            receivedPassword = binding.loginFragmentPasswordEtFoodBeneficiaryTv.text.toString()

            if (!LoginInputValidation.validateEmailInput(receivedEmail) || !LoginInputValidation.validateUserPassword(
                    receivedPassword
                )
            ) {
                Toast.makeText(
                    requireContext(),
                    "YOUR LOGIN CREDENTIALS ARE INVALID",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val login_request = LoginModel(email = receivedEmail, password = receivedPassword)
                viewModel.loginUser(login_request)
                binding.loginFragmentButtonFoodBeneficiaryTv.visibility = View.VISIBLE
            }
        }
        binding.loginFragmentEmailEtFoodBeneficiaryTv.addTextChangedListener {
            receivedEmail = binding.loginFragmentEmailEtFoodBeneficiaryTv.text.toString()
            onEmailTextChanged(receivedEmail)
        }
        binding.loginFragmentPasswordEtFoodBeneficiaryTv.addTextChangedListener {
            receivedPassword = binding.loginFragmentPasswordEtFoodBeneficiaryTv.text.toString()
            onPasswordTextChanged(receivedPassword)
        }
//        observeLoginResponse()
    }

    private fun onEmailTextChanged(receivedEmail: String) {
        if (LoginInputValidation.validateEmail(receivedEmail) == "Enter a valid Email Address") {
            binding.loginFragmentEmailEtFoodBeneficiaryTv.hint = "Enter a valid Email Address"
        } else if (LoginInputValidation.validateEmail(receivedEmail) == "Invalid Email Address") {
            binding.loginFragmentEmailEtFoodBeneficiaryTv.hint = "Invalid Email Address"
        } else {
            binding.loginFragmentEmailEtFoodBeneficiaryTv.hint = ""
        }
    }

    private fun onPasswordTextChanged(newPassword: String) {
        if (LoginInputValidation.validatePassword(newPassword) == "Password cannot be empty") {
            binding.loginFragmentPasswordEtFoodBeneficiaryTv.hint = "Password cannot be empty"
        } else if (LoginInputValidation.validatePassword(newPassword) == "Password must have a minimum of 8 characters.") {
            binding.loginFragmentPasswordEtFoodBeneficiaryTv.hint =
                "Password must have a minimum of 8 characters."
        } else if (LoginInputValidation.validatePassword(newPassword) == "Password must contain at least 1 number.") {
            binding.loginFragmentPasswordEtFoodBeneficiaryTv.hint =
                "Password must contain at least 1 number."
        } else if (LoginInputValidation.validatePassword(newPassword) == "Password must contain at least 1 upper case character.") {
            binding.loginFragmentPasswordEtFoodBeneficiaryTv.hint =
                "Password must contain at least 1 upper case character."
        } else if (LoginInputValidation.validatePassword(newPassword) == "Password must contain at least 1 lower case character.") {
            binding.loginFragmentPasswordEtFoodBeneficiaryTv.hint =
                "Password must contain at least 1 lower case character."
        } else if (LoginInputValidation.validatePassword(newPassword) == "Password must contain at least 1 special character (@#$%&?!).") {
            binding.loginFragmentPasswordEtFoodBeneficiaryTv.hint =
                "Password must contain at least 1 special character (@#$%&?!)."
        } else {
            binding.loginFragmentPasswordEtFoodBeneficiaryTv.hint = ""
        }
    }

//    fun observeLoginResponse() {
//        viewModel.loginResponse.observe(viewLifecycleOwner){
//            when (it) {
//                is Resource.Success<*> ->{
//                    Log.d("Login-succeed", it.message.toString())
//                    Log.d(TAG, "check token content: ${it.data?.data?.token}")
//
//                    // Save Token
//                   val receivedToken = it.data?.data?.token
//                    if (receivedToken != null){
//                        preference.putToken(receivedToken)
//                    }
//                    Log.d(TAG, "is the token captured: $receivedToken")
//
//                }                }
//            }
//
//    }
}


