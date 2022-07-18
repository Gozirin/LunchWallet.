package com.example.lunchwallet.foodbeneficiary.validations.InputValidations

object ResetPasswordValidation {
    private var EMAIL_PATTERN = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")

    fun validateEmail(email: String): String? {
        if (email.isEmpty()) {
            return "Enter a valid Email Address"
        }
        if (!email.matches(EMAIL_PATTERN)) {
            return "Invalid Email Address"
        }
        return null
    }
}
