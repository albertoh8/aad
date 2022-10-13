package com.albertoherjim.add.ut01.ex05.data.local

import android.content.SharedPreferences
import com.albertoherjim.add.ut01.ex05.domain.User
import com.google.gson.Gson

class UsersLocalDataSource(val sharedPref: SharedPreferences) {

    private val gson = Gson()

    fun saveUsers(users: List<User>) {
        users.forEach {
            saveUser(it)
        }
    }

    private fun saveUser(user: User) {
        val jsonUser: String = gson.toJson(user, User::class.java)

        val edit = sharedPref.edit()
        edit.putString(user.id.toString(), jsonUser)
        edit.apply()
    }


    fun getUsers(): List<User> {
        val userList = mutableListOf<User>()
        sharedPref.all.forEach { map ->
            userList.add(gson.fromJson(map.value as String, User::class.java))

        }
        return userList
    }


    fun findById(userId: Int): User? {
        val user: String? = sharedPref.getString(userId.toString(), null)
        return user?.let {
            gson.fromJson(it, User::class.java)
        }
    }

    fun remove(userId: Int) {
        sharedPref.edit().remove(userId.toString()).apply()
    }
}