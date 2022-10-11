package com.albertoherjim.add.UT01.Ex01.Presentation

import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.albertoherjim.add.R
import com.albertoherjim.add.UT01.Ex01.data.PreferenceLocalSource
import com.albertoherjim.add.UT01.Ex01.data.SharedPreferencesLocalSource
import com.albertoherjim.add.UT01.Ex01.domain.Custumer

class Ut01Ex01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)

        initSharedPreferences()
        initPreferences()

    }

    private fun initSharedPreferences(){
        //val spCustomer : SharedPreferencesLocalSource = SharedPreferencesLocalSource(this)
        val spCustomer = SharedPreferencesLocalSource(this)
        spCustomer.saveCostumer(Custumer(2,"Customer2","Surname2",true))

        val newCustomer = spCustomer.getCustumer()
        Log.d("@dev","Customer $newCustomer")

    }
    private fun initPreferences(){
        //val spCustomer : SharedPreferencesLocalSource = SharedPreferencesLocalSource(this)
        val spCustomer = PreferenceLocalSource(this)
        spCustomer.saveCostumer(Custumer(1,"Customer1","Surname1",true))

        val newCustomer = spCustomer.getCustumer()
        Log.d("@dev","Customer $newCustomer")

    }



}
