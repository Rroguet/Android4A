package com.esiea.android4a.presentation.register

sealed class RegisterStatus

data class RegisterSuccess(val login: String) : RegisterStatus()
object RegisterError : RegisterStatus()