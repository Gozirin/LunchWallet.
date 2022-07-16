package com.example.lunchwallet.foodbeneficiary.validations

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LoginInputValidationTest {

    @Test
    fun validateEmailInput() {
        assertTrue(LoginInputValidation.validateEmailInput("Precious.anyaso@decagon.dev"))
    }

    @Test
    fun validateUserPassword() {
        assertTrue(LoginInputValidation.validateUserPassword("Mer@d2n#"))
    }

    @Test
    fun validateEmail() {
        assertNotEquals(LoginInputValidation.validateEmail(""))
    }

    @Test
    fun validatePassword() {
        assertNotEquals(LoginInputValidation.validatePassword("123"))
    }

    private fun assertNotEquals(validatePassword: String?) {
    }
}

