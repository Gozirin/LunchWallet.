package com.example.lunchwallet.foodbeneficiary.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentCreateNewPasswordBinding
import com.example.lunchwallet.foodbeneficiary.validations.InputValidations.CreateNewPasswordValidation
import com.example.lunchwallet.foodbeneficiary.validations.LoginInputValidation

class CreateNewPasswordFragment : Fragment(R.layout.fragment_create_new_password) {

    private lateinit var binding: FragmentCreateNewPasswordBinding
    private lateinit var errorMsg: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout for this fragment
        binding = FragmentCreateNewPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }
    // initialising Binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        errorMsg = binding.ResetErrorMsg
        passwordNewFocusListener()
        passwordConfirmFocusListener()

        // Reset BUTTON
        onClickResetButton()

        // CreateNewPassword To SuccessModal
        binding.createNewPasswordFragmentButtonFoodBeneficiary.setOnClickListener {
            findNavController().navigate(R.id.action_createNewPasswordFragment_to_successModalFragment)
        }
    }

    private fun passwordNewFocusListener() {
        binding.createNewPasswordFragmentEditEmail2FoodBeneficiary.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.createNewPasswordFragmentEditEmail1FoodBeneficiary.helperText =
                    LoginInputValidation.validatePassword(binding.createNewPasswordFragmentEditEmail2FoodBeneficiary.text.toString())
        }
    }

    private fun passwordConfirmFocusListener() {
        binding.createNewPasswordFragmentEditPassword2FoodBeneficiary.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.createNewPasswordFragmentEditPassword1FoodBeneficiary.helperText =
                    LoginInputValidation.validatePassword(binding.createNewPasswordFragmentEditPassword2FoodBeneficiary.text.toString())
        }
    }

    private fun onClickResetButton() {
        binding.createNewPasswordFragmentEditEmail1FoodBeneficiary.helperText = CreateNewPasswordValidation.validatePassword(binding.createNewPasswordFragmentEditEmail2FoodBeneficiary.text.toString())
        binding.createNewPasswordFragmentEditPassword1FoodBeneficiary.helperText = CreateNewPasswordValidation.validatePassword(binding.createNewPasswordFragmentEditPassword2FoodBeneficiary.text.toString())

        val validNewPasswordInput = LoginInputValidation.validateEmail(binding.createNewPasswordFragmentEditEmail2FoodBeneficiary.text.toString()) == null
        val validConfirmPasswordInput = LoginInputValidation.validatePassword(binding.createNewPasswordFragmentEditPassword2FoodBeneficiary.text.toString()) == null

        if (validNewPasswordInput && validConfirmPasswordInput) {
            // todo
        } else {
            invalidCredentials()
        }
    }
    private fun invalidCredentials() {
        var message = ""
        if (binding.createNewPasswordFragmentEditEmail1FoodBeneficiary.helperText != null) {
            message = "\n\nEmail: " + binding.createNewPasswordFragmentEditEmail1FoodBeneficiary.helperText
        }

        if (binding.createNewPasswordFragmentEditPassword1FoodBeneficiary.helperText != null) {
            message = "\n\nEmail: " + binding.createNewPasswordFragmentEditPassword1FoodBeneficiary.helperText
        }
    }
}
