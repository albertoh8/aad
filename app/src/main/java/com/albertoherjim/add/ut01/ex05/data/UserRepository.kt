package com.albertoherjim.add.ut01.ex05.data

import android.content.SharedPreferences
import com.albertoherjim.add.ut01.ex05.data.local.UsersLocalDataSource
import com.albertoherjim.add.ut01.ex05.data.remote.UsersRemoteDataSource
import com.albertoherjim.add.ut01.ex05.domain.User
import com.google.gson.Gson

class UserRepository(val localSource: UsersLocalDataSource, val remoteSource: UsersRemoteDataSource, val sharedPref : SharedPreferences) {

    private val gson = Gson()

    /**
     * First from local and then from remote
     */
    fun getUsers(): List<User>{
        var users = localSource.getUsers()
        if(users.isEmpty()){
            users = remoteSource.getUsers()
            localSource.saveUsers(users)
        }
        return users
    }

    fun getUserById(userId: Int): User{
        val jsonUser = sharedPref.getString(userId.toString(),"")
        return gson.fromJson(jsonUser, User::class.java)
    }

    fun removeUser(userId: Int){
        //Todo (local)
    }
}