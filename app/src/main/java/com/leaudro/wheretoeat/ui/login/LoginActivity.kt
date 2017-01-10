package com.leaudro.wheretoeat.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.leaudro.wheretoeat.App
import com.leaudro.wheretoeat.R
import com.leaudro.wheretoeat.ui.places.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if ((application as App).userName.isEmpty()) {
            setContentView(R.layout.activity_login)
            setupUI()
        } else {
            startMainActivity()
        }
    }

    private fun setupUI() {
        setSupportActionBar(toolbar)
        signInButton.setOnClickListener {
            val userName = edit_user.editText?.text.toString()
            if (userName.isNotEmpty()) {
                (application as App).userName = userName
                startMainActivity()
            }
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
