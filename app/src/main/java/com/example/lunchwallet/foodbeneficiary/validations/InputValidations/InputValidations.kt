package com.example.lunchwallet.foodbeneficiary.validations.InputValidations

var result = false
object InputValidations {

    private var EMAIL_PATTERN = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")
    private val validatePassword = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}\$")

    fun validateNewPassword(password: String): Boolean {
        return if (password.isEmpty()) {
            false
        } else validatePassword.matches(password)
    }

    fun validateConfirmPassword(password: String, confirmPassword: String): Boolean {
        if (password != confirmPassword) {
            return false
        }
        return true
    }

    fun validateEmailInput(email: String): Boolean {
        if (email.isEmpty() || !email.matches(EMAIL_PATTERN)) {
            return false
        }
        return true
    }

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
fun validatePassword(passwordText: String): String? {
    if (passwordText.isEmpty()) {
        return "Password cannot be empty"
    }
    if (passwordText.length < 6) {
        return "Password must have a minimum of 6 characters."
    }
    if (!passwordText.matches(".*[0-9].*".toRegex())) {
        return "Password must contain at least 1 number."
    }
    if (!passwordText.matches(".*[A-Z].*".toRegex())) {
        return "Password must contain at least 1 upper case character."
    }
    if (!passwordText.matches(".*[a-z].*".toRegex())) {
        return "Password must contain at least 1 lower case character."
    }
    if (!passwordText.matches(".*[`~!@#$%^&*()\\-_=+|}{\\]\\[\"\';:?/>.<,].*".toRegex())) {
        return "Password must contain at least 1 special character (@#$%&?!)."
    }
    return ""
}

