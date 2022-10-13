package com.albertoherjim.add.ut01.Ex02.data

import android.content.Context
import com.albertoherjim.add.ut01.Ex02.domain.firstTimeOpener

class PreferencesLocalSource(private val context: Context) {
    val sharedPref = context.getSharedPreferences(
        "Ut01Ex02Activity",
        Context.MODE_PRIVATE
    )

    fun firstTime(firstTimeOpener: Boolean){
        val editor = sharedPref.edit()
        editor.apply{
            putBoolean("isOpener",firstTimeOpener)
        }
    }
    fun getFirstTime(): firstTimeOpener {
        return firstTimeOpener(
            sharedPref.getBoolean("isOpener", true)
        )
    }
}