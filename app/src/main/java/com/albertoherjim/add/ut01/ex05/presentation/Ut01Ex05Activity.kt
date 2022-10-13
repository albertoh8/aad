package com.albertoherjim.add.ut01.ex05.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.albertoherjim.add.ut01.ex05.data.local.UsersLocalDataSource
import com.albertoherjim.add.ut01.ex05.domain.User

class Ut01Ex05Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        saveUserList()
        getAllUsers()
        removeById(2)
    }



    private fun saveUserList(){

        val usersList: MutableList<User> = mutableListOf(
        User(1, "Nombre1", "Username1"),
        User(2, "Nombre2", "Username2"),
        User(3, "Nombre3", "Username3"),
        )
        val userLocalSource = UsersLocalDataSource(
            getPreferences(MODE_PRIVATE)
        )

        userLocalSource.saveUsers(usersList)
    }

    private fun getAllUsers(){
        val userLocalSource = UsersLocalDataSource(
            getPreferences(Context.MODE_PRIVATE)
        )

        val Usuarios = userLocalSource.getUsers()

        Log.d("@dev","Usuarios: $Usuarios")
    }

    private fun removeById (userId: Int){
        val userLocalSource = UsersLocalDataSource(
            getPreferences(Context.MODE_PRIVATE)
        )

        userLocalSource.remove(userId)

    }
}