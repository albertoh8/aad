package com.albertoherjim.add.UT01.Ex01.data;

import android.content.Context
import androidx.appcompat.app.AppCompatActivity;
import com.albertoherjim.add.R
import com.albertoherjim.add.UT01.Ex01.domain.Custumer

class SharedPreferencesLocalSource(val context: Context) {

    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.prefence_ut01ex01), Context.MODE_PRIVATE)

    fun saveCostumer(customer: Custumer){
        val editor = sharedPref.edit()
        //kotlin style
        editor.apply {
            putInt("id",customer.id)
            putString("name", customer.name)
            putString("surname", customer.surname)
            putBoolean("is_active",customer.isActive)
            apply()
        }
        /*
        editor.putInt("id",customer.id)
        editor.putString("name", customer.name)
        editor.putString("surname", customer.surname)
        editor.putBoolean("is_active",customer.isActive)
        editor.apply() //asincrono
        //editor.commit() //sincrono

        */
    }

    fun getCustumer(): Custumer {
        return Custumer(
            sharedPref.getInt("id",0),
            sharedPref.getString("name","no existe")!!,
            sharedPref.getString("surname","no existe")!!,
            sharedPref.getBoolean("is_active",true)

        )
    }


}
