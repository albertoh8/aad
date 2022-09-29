package com.albertoherjim.add.UT01.Ex02.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.albertoherjim.add.R
import com.albertoherjim.add.UT01.Ex02.data.PreferencesLocalSource

class Ut01Ex02Activity : AppCompatActivity() {

    var firstTimeOpener = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex01)

        initPreferenceLocal()
    }

    private fun initPreferenceLocal(){

        val spfirstTime = PreferencesLocalSource(this)
        spfirstTime.firstTime(true)

        val isOpener = spfirstTime.getFirstTime()
        Log.d("@dev", "First Time Opener?: $isOpener")

    }




}
/*
* Se necesita saber cuando es la primera vez que se abre la app
* */