package com.example.lunchwallet.foodbeneficiary.ui.main.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentSignUpBinding
import com.example.lunchwallet.util.validation.FieldValidationTracker
import com.example.lunchwallet.util.validation.FieldValidationTracker.populateFieldTypeMap
import com.example.lunchwallet.util.validation.FieldValidations.verifyEmail
import com.example.lunchwallet.util.validation.FieldValidations.verifyLocation
import com.example.lunchwallet.util.validation.FieldValidations.verifyName
import com.example.lunchwallet.util.validation.FieldValidations.verifyPassword
import com.example.lunchwallet.util.validation.FieldValidations.verifyStack
import com.example.lunchwallet.util.validation.observeFieldsValidationToEnableButton
import com.example.lunchwallet.util.validation.validateConfirmPassword
import com.example.lunchwallet.util.validation.validateField

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        stackDropDown()
        locationDropDown()
        validateFields()
    }
    override fun onResume() {
        super.onResume()
        binding.fullNameTv.clearFocus()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun stackDropDown() {
        val stack = resources.getStringArray(R.array.stack)
        val adapter = ArrayAdapter(requireContext(), R.layout.stack_list, stack)
        with(binding.signUpStackAutoView) {
            setAdapter(adapter)
        }
    }

    private fun locationDropDown() {
        val location = resources.getStringArray(R.array.location)
        val adapter = ArrayAdapter(requireContext(), R.layout.location_list, location)
        with(binding.signUpLocationAutoView) {
            setAdapter(adapter)
        }
    }

    private fun validateFields() {

        val fieldTypesToValidate = listOf(
            FieldValidationTracker.FieldType.NAME,
            FieldValidationTracker.FieldType.EMAIL,
            FieldValidationTracker.FieldType.STACK,
            FieldValidationTracker.FieldType.LOCATION,
            FieldValidationTracker.FieldType.PASSWORD,
            FieldValidationTracker.FieldType.CONFIRM_PASSWORD
        )
        populateFieldTypeMap(fieldTypesToValidate)

        binding.apply {
            fullNameContainer.validateField(
                getString(R.string.enter_valid_name_str), FieldValidationTracker.FieldType.NAME
            ) { input ->
                verifyName(input)
            }
            emailContainer.validateField(
                getString(R.string.enter_valid_email_str), FieldValidationTracker.FieldType.EMAIL
            ) { input ->
                verifyEmail(input)
            }

            stackContainer.validateField(
                getString(R.string.select_stack), FieldValidationTracker.FieldType.STACK
            ) { input ->
                verifyStack(input)
            }

            locationContainer.validateField(
                getString(R.string.select_location), FieldValidationTracker.FieldType.LOCATION
            ) { input ->
                verifyLocation(input)
            }
            passwordContainer.validateField(
                getString(R.string.enter_valid_password_str),
                FieldValidationTracker.FieldType.PASSWORD
            ) { input ->
                verifyPassword(input)
            }
            confirmPasswordContainer.validateConfirmPassword(
                passwordContainer, FieldValidationTracker.FieldType.CONFIRM_PASSWORD,
                getString(R.string.enter_valid_confirm_password_str)
            )

            signUpBtn.observeFieldsValidationToEnableButton(
                requireContext(),
                viewLifecycleOwner
            )

            signUpBtn.setOnClickListener {
                findNavController().navigate(R.id.checkMailFragment)
            }
        }
    }
}
