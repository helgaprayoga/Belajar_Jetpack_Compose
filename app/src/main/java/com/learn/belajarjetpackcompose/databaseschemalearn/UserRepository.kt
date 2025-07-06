package com.learn.belajarjetpackcompose.databaseschemalearn

import kotlinx.coroutines.flow.StateFlow

class UserRepository(private val userDao: UserDao) {

    val readAllData: StateFlow<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}