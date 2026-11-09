package com.app.bookfinder.data.local.repository

import com.app.bookfinder.data.local.UserDao
import com.app.bookfinder.data.local.UserEntity

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun getLastLoggedUser(): UserEntity? {
        return userDao.getLastLoggedUser()
    }
}