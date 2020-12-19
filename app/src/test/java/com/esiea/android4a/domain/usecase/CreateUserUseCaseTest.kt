package com.esiea.android4a.domain.usecase

import com.esiea.android4a.data.repository.UserRespository
import com.esiea.android4a.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CreateUserUseCaseTest {
    private val userRespository: UserRespository = mockk()

    private val classUnderTest = CreateUserUseCase(userRespository)

    @Test
    fun invoke(){
        runBlocking {
            val user = User("","")
            coEvery { userRespository.createUser(user)} returns Unit

            classUnderTest.invoke(user)

            coVerify(exactly = 1) { userRespository.createUser(user) }
        }
    }
}