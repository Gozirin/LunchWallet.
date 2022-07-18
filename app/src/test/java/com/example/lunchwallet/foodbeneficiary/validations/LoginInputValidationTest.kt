package com.example.lunchwallet.foodbeneficiary.validations

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LoginInputValidationTest {

    @Test
    fun validateEmailInput() {
        assertEquals(LoginInputValidation.validateEmail("Precious.anyaso@decagon.dev"))
    }

    private fun assertEquals(validateEmail: String?) {
        TODO("Not yet implemented")
    }

    @Test
    fun validateUserPassword() {
        assertEquals(LoginInputValidation.validatePassword("Mer@d2n#"))
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

