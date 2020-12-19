package com.esiea.android4a.data.repository

import com.esiea.android4a.data.local.DatabaseDao
import com.esiea.android4a.data.local.models.toData
import com.esiea.android4a.data.local.models.toEntity
import com.esiea.android4a.domain.entity.User

class UserRespository(
    private val databaseDao: DatabaseDao
) {

    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun getUser(name: String): User{
        val userLocal = databaseDao.findByName(name)
        return userLocal.toEntity()
    }

}