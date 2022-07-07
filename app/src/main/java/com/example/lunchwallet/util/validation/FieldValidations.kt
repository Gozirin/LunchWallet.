package com.example.lunchwallet.util.validation

import com.example.lunchwallet.R

// Validation object for Sign-Up
object FieldValidations {

    // Function to verify the name of the intended user
    fun verifyName(name: String): Boolean {
        val regex = Regex("^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)")
        return name.isNotBlank() && name.matches(regex) && name.length >= 2
    }

    // Function to verify the e-mail of the intended user
    fun verifyEmail(email: String): Boolean {
        val regex = Regex("^[a-zA-Z.]+@(?:(?:[a-zA-Z-]+\\.)?[a-zA-Z]+\\.)?(decagon.dev|decagonhq.com)\$")
        return email.isNotBlank() && email.matches(regex)
    }

    fun verifyStack(stack: String): Boolean {
        return stack.isNotEmpty()
    }

    fun verifyLocation(location: String): Boolean {
        return location.isNotEmpty()
    }

    // Function to verify the password of the intended user
    fun verifyPassword(password: String): Boolean {
        val regex = Regex(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,15}\$"
        )
        return password.isNotBlank() && password.matches(regex)
    }

    fun validateConfirmPassword(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword && password.isNotBlank()
    }
}
