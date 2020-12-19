package com.esiea.android4a.domain.usecase

import com.esiea.android4a.data.repository.UserRespository
import com.esiea.android4a.domain.entity.User

class GetUserUseCase (
    private val userRespository: UserRespository
) {
    suspend fun invoke(name: String): User {
        return userRespository.getUser(name)
    }
}