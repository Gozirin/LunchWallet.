package com.example.lunchwallet.foodbeneficiary.data.sharedpreference

interface Preference {
    fun putToken(token: String)

    fun getToken(): String
}