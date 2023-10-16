package com.example.melinastore.db

interface IUser {
    fun createUser(name: String, username: String, email: String, password: String): Long

    fun login(username: String, password: String): Boolean
}