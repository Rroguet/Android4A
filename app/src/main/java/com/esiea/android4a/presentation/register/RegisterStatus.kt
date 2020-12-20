package com.esiea.android4a.presentation.register

sealed class RegisterStatus

object RegisterSuccess : RegisterStatus()
object RegisterError : RegisterStatus()