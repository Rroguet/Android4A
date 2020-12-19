package com.esiea.android4a.domain.usecase

import com.esiea.android4a.data.repository.UserRespository
import com.esiea.android4a.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest {
    private val userRespository: UserRespository = mockk()

    private val classUnderTest = GetUserUseCase(userRespository)

    @Test
    fun `invoke with invalid login`(){
        runBlocking {
            val login = ""
            val password = ""
            coEvery { userRespository.getUser(login,password)} returns null

            val result = classUnderTest.invoke(login,password)

            coVerify(exactly = 1) { userRespository.getUser(login,password) }
            assertEquals(result, null)
        }
    }

    @Test
    fun `invoke with valid login`(){
        runBlocking {
            val login = "aa"
            val password = "aa"
            val expectedUser = User("aa","aa")
            coEvery { userRespository.getUser(login,password)} returns expectedUser

            val result = classUnderTest.invoke(login,password)

            coVerify(exactly = 1) { userRespository.getUser(login,password) }
            assertEquals(result, expectedUser)
        }
    }
}