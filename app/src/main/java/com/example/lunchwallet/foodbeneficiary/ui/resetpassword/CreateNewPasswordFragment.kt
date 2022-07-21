package com.example.lunchwallet.foodbeneficiary.ui.resetpassword

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentCreateNewPasswordBinding
import com.example.lunchwallet.foodbeneficiary.validations.InputValidations.CreateNewPasswordValidation
import com.example.lunchwallet.foodbeneficiary.validations.loginvalidation.LoginInputValidation
import com.google.android.material.snackbar.Snackbar

class CreateNewPasswordFragment : Fragment(R.layout.fragment_create_new_password) {
    val TAG = "CreateNewPassword"
    private lateinit var binding: FragmentCreateNewPasswordBinding
    private lateinit var errorMsg: TextView
    private lateinit var etPassword1: TextView
    private lateinit var etPassword2: TextView

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

        // CreateNewPassword To SuccessModal
        binding.createNewPasswordFragmentButtonFoodBeneficiary.setOnClickListener {
            // Reset BUTTON
            onClickResetButton()
            //  findNavController().navigate(R.id.action_createNewPasswordFragment_to_successModalFragment)
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
        etPassword1 = binding.createNewPasswordFragmentEditEmail2FoodBeneficiary
        etPassword2 = binding.createNewPasswordFragmentEditPassword2FoodBeneficiary

        binding.createNewPasswordFragmentEditEmail1FoodBeneficiary.helperText = CreateNewPasswordValidation.validatePassword(binding.createNewPasswordFragmentEditEmail2FoodBeneficiary.text.toString())
        binding.createNewPasswordFragmentEditPassword1FoodBeneficiary.helperText = CreateNewPasswordValidation.validatePassword(binding.createNewPasswordFragmentEditPassword2FoodBeneficiary.text.toString())

        val validNewPasswordInput = LoginInputValidation.validateEmail(binding.createNewPasswordFragmentEditEmail2FoodBeneficiary.text.toString()) != null
        val validConfirmPasswordInput = LoginInputValidation.validatePassword(binding.createNewPasswordFragmentEditPassword2FoodBeneficiary.text.toString()) != null

        if (validNewPasswordInput && validConfirmPasswordInput) {
            if (etPassword1.text.toString() != "" && etPassword2.text.toString() != "") {
                Log.i(TAG, "onClickResetButton clicked ")
                etPassword1.text = ""
                etPassword2.text = ""

                //            Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show()
                view?.let {
                    Snackbar.make(it, "Password Reset Successfully", Snackbar.LENGTH_LONG)
                        .setBackgroundTint(Color.parseColor("#FD5900"))
                        .show()
                }
            }
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
