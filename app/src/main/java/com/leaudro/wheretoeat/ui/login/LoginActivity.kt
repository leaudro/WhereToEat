package com.leaudro.wheretoeat.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
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
        setTitle(R.string.login)
        signInButton.setOnClickListener {
            val userName = edit_user.editText?.text.toString()
            if (userName.trim().length > 2) {
                (application as App).userName = userName
                startMainActivity()
            } else {
                edit_user.error = getString(R.string.msg_error_empty_login)
                Handler().postDelayed({ edit_user.error = null }, 3000)
            }
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
