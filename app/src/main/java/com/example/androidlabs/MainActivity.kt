package com.example.androidlabs

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val prefs = getSharedPreferences("users", Context.MODE_PRIVATE)
        emailTextLogin.setText(prefs.getString("emailAddress", ""))
        loginButton.setOnClickListener {
            Intent(this, ProfileActivity::class.java)
                .putExtra("emailAddress", emailTextLogin.text.toString())
                .also {
                startActivity(it)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        val prefs = getSharedPreferences("users", Context.MODE_PRIVATE)
        with(prefs.edit()) {
            putString("emailAddress", emailTextLogin.text.toString())
            commit()
        }
    }
}
