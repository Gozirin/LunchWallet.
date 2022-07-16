package com.example.lunchwallet.foodbeneficiary.data.model.AuthModel

data class LoginResponse(
    val `data`: DataX,
    val errors: Any,
    val message: String,
    val success: Boolean
)
