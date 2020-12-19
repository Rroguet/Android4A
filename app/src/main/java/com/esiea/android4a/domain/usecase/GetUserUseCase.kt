package com.esiea.android4a.domain.usecase

import com.esiea.android4a.data.repository.UserRespository
import com.esiea.android4a.domain.entity.User

class GetUserUseCase (
    private val userRespository: UserRespository
) {
    suspend fun invoke(login: String, password: String): User? {
        return userRespository.getUser(login, password)
    }
}