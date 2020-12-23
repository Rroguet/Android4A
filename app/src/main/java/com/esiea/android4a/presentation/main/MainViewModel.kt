package com.esiea.android4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.android4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){
    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(login: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(login, password)
            val loginStatus = if (login == "" || password == ""){
                LoginEmpty
            }else {
                if (user != null) {
                    LoginSuccess
                } else {
                    LoginError
                }
            }

            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }
        }
    }
}