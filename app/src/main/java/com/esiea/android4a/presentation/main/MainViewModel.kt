package com.esiea.android4a.presentation.main

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.android4a.domain.entity.User
import com.esiea.android4a.domain.usecase.CreateUserUseCase
import com.esiea.android4a.domain.usecase.GetUserUseCase
import com.esiea.android4a.presentation.register.RegisterActivity
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
            val loginStatus = if (user != null) {
                LoginSuccess(user.login)
            } else {
                LoginError
            }

            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }

            //createUserUseCase.invoke(User("nom_est_test"))
            //val user = getUserUseCase.invoke("nom_est_test")
        }
    }
}