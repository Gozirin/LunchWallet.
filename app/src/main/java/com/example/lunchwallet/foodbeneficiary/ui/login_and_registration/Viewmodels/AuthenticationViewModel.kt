package com.example.lunchwallet.foodbeneficiary.ui.login_and_registration.Viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import com.example.lunchwallet.foodbeneficiary.data.model.AuthModel.LoginModel
import com.example.lunchwallet.foodbeneficiary.data.model.AuthModel.LoginResponse
import kotlinx.coroutines.launch

class AuthenticationViewModel : ViewModel() {
    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>> = _loginResponse

    fun loginUser(loginModel: LoginModel) {
        //        _loginResponse.value = Resource.Loading()
        viewModelScope.launch {
            //    _loginResponse.value = authRepository.loginUser(loginModel)
        }
    }
}
