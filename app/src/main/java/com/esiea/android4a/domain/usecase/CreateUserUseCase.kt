package com.esiea.android4a.domain.usecase

import com.esiea.android4a.data.repository.UserRespository
import com.esiea.android4a.domain.entity.User

class CreateUserUseCase(
    private val userRespository: UserRespository
) {
    suspend fun invoke(user: User){
        userRespository.createUser(user)
    }
}