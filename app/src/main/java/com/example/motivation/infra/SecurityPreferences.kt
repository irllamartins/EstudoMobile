package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences( context: Context) {
    private val mSharedPreferences = context.getSharedPreferences("Motivation",Context.MODE_PRIVATE)

    //salva valor
    fun storeString(key:String,value: String){
        mSharedPreferences.edit().putString(key,value).apply()
    }
    fun getString(key:String):String{
        //se a primeira parte for diferente de nulo realiza a operação até antes de ?: senão vai retornar ""
        return mSharedPreferences.getString(key,"")?:""
    }
}