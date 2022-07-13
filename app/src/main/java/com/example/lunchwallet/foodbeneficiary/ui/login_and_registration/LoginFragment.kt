package com.example.lunchwallet.foodbeneficiary.ui.login_and_registration

import android.os.Bundle
import android.preference.Preference
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.load.engine.Resource
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginFragmentButtonFoodBeneficiaryTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_resetPasswordFragment)
        }
    }
}



//// CODE FOR LOGIN VALIDATION
//
//@AndroidEntryPoint
//class SupplierLoginFragment : Fragment() {
//    @Inject
//    lateinit var preference: Preference
//    private val TAG = "SupplierLoginFragment"
//    private lateinit var binding: FragmentSupplierLoginBinding
//    private val viewModel: AuthenticationViewModel by viewModels()
//    private lateinit var connectivityLiveData: ConnectivityLiveData
//    private lateinit var userInfo: LoginModel
//    private lateinit var bundle: Bundle
//    private lateinit var receivedEmail: String
//    private lateinit var receivedPassword: String
//    private lateinit var errorMsg: TextView
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?,
//    ): View? {
//        // Inflate the layout for this fragment
//        val binding = inflater.inflate(R.layout.fragment_supplier_login, container, false)
//        return binding.rootView
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        connectivityLiveData = ConnectivityLiveData(requireActivity().application)
//        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentSupplierLoginBinding.bind(view)
//        bundle = Bundle()
//        makeCompanyListCall()
//        binding.supplierLoginLayoutPasswordLo.helperText = ""
//        binding.supplierLoginLayoutEmailLo.helperText = ""
//        errorMsg = binding.supplierLoginErrorMsg
//        // navigate to supplier forgot password page
//        binding.supplierLoginLayoutTextViewForgetPassword.setOnClickListener {
//            findNavController().navigate(R.id.action_supplierLoginFragment_to_consumerForgotPasswordFragment)
//        }
//
//        binding.supplierLoginSignup.setOnClickListener {
//            if (bundle.isEmpty) {
//                Toast.makeText(
//                    requireContext(),
//                    "Please Check your Internet connection",
//                    Toast.LENGTH_SHORT
//                ).show()
//            } else {
//                findNavController().navigate(
//                    R.id.action_supplierLoginFragment_to_supplierSignUpFragment,
//                    bundle
//                )
//            }
//        }
//
//        binding.supplierLoginLayoutLoginButton.setOnClickListener {
//            receivedEmail = binding.supplierLoginLayoutEditTextEmail.text.toString()
//            receivedPassword = binding.supplierLoginLayoutEditTextPassword.text.toString()
//
//            if (!InputValidation.validateEmailInput(receivedEmail) || !InputValidation.validateUserPassword(receivedPassword)) {
//                Toast.makeText(requireContext(), "Your login credentials are invalid", Toast.LENGTH_SHORT).show()
//            } else {
//                userInfo = LoginModel(email = receivedEmail, password = receivedPassword)
//                viewModel.loginUser(userInfo)
//                binding.supplierLoginProgressBar.visibility = View.VISIBLE
//            }
//        }
//        /**
//         * observe the login response
//         */
//        viewModel.loginResponse.observe(viewLifecycleOwner) {
//            // if (it.data?.success == true) {
//            when (it) {
//                is Resource.Loading -> {
//                    binding.supplierLoginProgressBar.visibility = View.VISIBLE
//                }
//                is Resource.Error -> {
//                    Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_SHORT).show()
//
//                    binding.supplierLoginProgressBar.visibility = View.GONE
//                }
//                is Resource.Success -> {
//                    if (it.data?.success == true) {
//                        Log.d(TAG, "check supplier token content: ${it.data.data.token}")
//                        // save token
//                        val receivedSupllierToken = it.data.data.token
//                        if (receivedSupllierToken != null) {
//                            preference.putSupplierToken(receivedSupllierToken)
//                        }
//                        Log.d(TAG, "is the supplier token captured: ${preference.getSupplierToken()}")
//                        errorMsg.text = null
//                        binding.supplierLoginProgressBar.visibility = View.GONE
//                        findNavController().navigate(R.id.action_supplierLoginFragment_to_supplier_mainActivity)
//                    }
//                }
//            }
//        }
//        /**
//         * add TextChangeListener to views
//         */
//        binding.supplierLoginLayoutEditTextEmail.addTextChangedListener {
//            receivedEmail = binding.supplierLoginLayoutEditTextEmail.text.toString()
//            onEmailTextChanged(receivedEmail)
//        }
//        binding.supplierLoginLayoutEditTextPassword.addTextChangedListener {
//            receivedPassword = binding.supplierLoginLayoutEditTextPassword.text.toString()
//            onPasswordTextChanged(receivedPassword)
//        }
//
//        connectivityLiveData.observe(
//            viewLifecycleOwner,
//            Observer { isAvailable ->
//                when (isAvailable) {
//                    false -> {
//                        Toast.makeText(requireContext(), "Please Check your Internet connection", Toast.LENGTH_SHORT).show()
//                    }
//                    true -> {
//                        makeCompanyListCall()
//                    }
//                }
//            }
//        )
//    }
//
//    private fun makeCompanyListCall() {
//        viewModel.getCompanies()
//        viewModel.companyList.observe(requireActivity()) {
//            when (it) {
//                is Resource.Success -> {
//                    bundle = Bundle().apply {
//                        putSerializable("list", it.data)
//                    }
//                }
//            }
//        }
//    }
//
//    private fun onPasswordTextChanged(receivedPassword: String) {
//        if (InputValidation.validatePassword(receivedPassword) == "Password cannot be empty") {
//            binding.supplierLoginLayoutPasswordLo.helperText = "Password cannot be empty"
//        } else if (InputValidation.validatePassword(receivedPassword) == "Password must have a minimum of 8 characters.") {
//            binding.supplierLoginLayoutPasswordLo.helperText = "Password must have a minimum of 8 characters."
//        } else if (InputValidation.validatePassword(receivedPassword) == "Password must contain at least 1 number.") {
//            binding.supplierLoginLayoutPasswordLo.helperText = "Password must contain at least 1 number."
//        } else if (InputValidation.validatePassword(receivedPassword) == "Password must contain at least 1 upper case character.") {
//            binding.supplierLoginLayoutPasswordLo.helperText = "Password must contain at least 1 upper case character."
//        } else if (InputValidation.validatePassword(receivedPassword) == "Password must contain at least 1 lower case character.") {
//            binding.supplierLoginLayoutPasswordLo.helperText = "Password must contain at least 1 lower case character."
//        } else if (InputValidation.validatePassword(receivedPassword) == "Password must contain at least 1 special character (@#$%&?!).") {
//            binding.supplierLoginLayoutPasswordLo.helperText = "Password must contain at least 1 special character (@#$%&?!)."
//        } else {
//            binding.supplierLoginLayoutPasswordLo.helperText = ""
//        }
//    }
//
//    private fun onEmailTextChanged(receivedEmail: String) {
//        if (InputValidation.validateEmail(receivedEmail) == "Enter a valid Email Address") {
//            binding.supplierLoginLayoutEmailLo.helperText = "Enter a valid Email Address"
//        } else if (InputValidation.validateEmail(receivedEmail) == "Invalid Email Address") {
//            binding.supplierLoginLayoutEmailLo.helperText = "Invalid Email Address"
//        } else {
//            binding.supplierLoginLayoutEmailLo.helperText = ""
//        }
//    }
//}
