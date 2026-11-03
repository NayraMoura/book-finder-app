package com.app.bookfinder.data.repository

import com.app.bookfinder.data.local.UserDao
import com.app.bookfinder.data.local.UserEntity

class UserRepository(private val userDao: UserDao) {

    suspend fun saveUser(username: String) {
        val user = UserEntity(username = username)
        userDao.insertUser(user)
    }

    suspend fun getLastLoggedUser(): UserEntity? {
        return userDao.getLastLoggedUser()
    }
}