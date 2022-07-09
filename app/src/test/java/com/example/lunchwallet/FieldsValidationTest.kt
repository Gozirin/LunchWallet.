package com.example.lunchwallet

import com.example.lunchwallet.util.validation.FieldValidations
import org.junit.Assert
import org.junit.Test

// Unit test cases for testing possible input scenarios from the user.
class FieldsValidationTest {

    private var password = "Kung+=3452"

    @Test
    fun `incorrect email address pattern`() {
        Assert.assertFalse(FieldValidations.verifyEmail(".hdd@jj.com"))
    }

    @Test
    fun `another incorrect email address pattern`() {
        Assert.assertFalse(FieldValidations.verifyEmail("johnsonred@gmail.com"))
    }

    @Test
    fun `no email address`() {
        Assert.assertFalse(FieldValidations.verifyEmail(""))
    }

    @Test
    fun `correct email address pattern`() {
        Assert.assertTrue(FieldValidations.verifyEmail("johnsonred@decagonhq.com"))
    }
    @Test
    fun `another correct email address pattern`() {
        Assert.assertTrue(FieldValidations.verifyEmail("johnsonred@decagon.dev"))
    }

    @Test
    fun `one name provided`() {
        Assert.assertFalse(FieldValidations.verifyName("Joe"))
    }

    @Test
    fun `incorrect name provided`() {
        Assert.assertFalse(FieldValidations.verifyName("#yemi"))
    }

    @Test
    fun `no name`() {
        Assert.assertFalse(FieldValidations.verifyName(""))
    }

    @Test
    fun `correct name provided`() {
        Assert.assertTrue(FieldValidations.verifyName("Joe Okoro"))
    }

    @Test
    fun `no stack selected`() {
        Assert.assertFalse(FieldValidations.verifyStack(""))
    }

    @Test
    fun `no location selected`() {
        Assert.assertFalse(FieldValidations.verifyLocation(""))
    }
    @Test
    fun `password with no uppercase`() {
        Assert.assertFalse(FieldValidations.verifyPassword("benry6526dwbs"))
    }
    @Test
    fun `password with no digit`() {
        Assert.assertFalse(FieldValidations.verifyPassword("@#Artsisyd"))
    }

    @Test
    fun `password less than 8`() {
        Assert.assertFalse(FieldValidations.verifyPassword("miGh45="))
    }

    @Test
    fun `correct password`() {
        Assert.assertTrue(FieldValidations.verifyPassword(password))
    }
}
