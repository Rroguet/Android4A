package com.esiea.android4a.presentation.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.android4a.domain.entity.User
import com.esiea.android4a.domain.usecase.CreateUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel(
    private val createUserUseCase: CreateUserUseCase
) : ViewModel() {
    val registerLiveData : MutableLiveData<RegisterStatus> = MutableLiveData()

    fun onClickedRegister(login: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val registerStatus = if (login != "" && password != "") {
                createUserUseCase.invoke(User(login, password))
                RegisterSuccess(login)
            } else {
                RegisterError
            }

            withContext(Dispatchers.Main) {
                registerLiveData.value = registerStatus
            }
        }
    }
}