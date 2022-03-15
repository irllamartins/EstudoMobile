package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
//import android.widget.Toolbar
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*



class SplashActivity() : AppCompatActivity(), View.OnClickListener{

    private lateinit var mSecurityPreferences : SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)

        //tira o actionbar que fica com a configuração padrão
        if(supportActionBar!=null){
            supportActionBar!!.hide()
        }
        var buttonId = findViewById<Button>(R.id.buttonSave)

        buttonId.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if(view.id == R.id.buttonSave){
            handleSave()
        }
    }
    private fun handleSave(){
        val name = editName.text.toString()

        if (name!=""){
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME,name)
            //passa para outro layout
            startActivity(Intent(this, MainActivity::class.java))
        }else {
            Toast.makeText(this, R.string.name_null,Toast.LENGTH_SHORT).show()
        }
    }


}


