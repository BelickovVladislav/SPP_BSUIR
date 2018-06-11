package com.appyfurious.spp_bsuir.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.appyfurious.spp_bsuir.R
import com.appyfurious.spp_bsuir.repository.AuthRepository
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val authRepository = AuthRepository()

    private var isActivityLogin = true

    private var userType: String? = null

    private val authListener = View.OnClickListener {
        authRepository.isValid(email.text.toString(), password.text.toString(), userType) {
            if (it) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, R.string.error_auth, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val registrationListener = View.OnClickListener {
        authRepository.authNewUser(fullName.text.toString(), email.text.toString(), password.text.toString(), userType) {
            if (it) {
                statusActivity(true)
                Toast.makeText(this, R.string.success_register, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, R.string.error_register, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        authRepository.isAuth { isAuth ->
            if (isAuth) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

        statusActivity(true)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, authRepository.usersTypeList)
        userTypeListSpinner.adapter = adapter
        userTypeListSpinner.onItemSelectedListener = this

        newAccount.setOnClickListener {
            statusActivity(false)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>) {

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        userType = authRepository.usersTypeList[position]
    }

    override fun onSupportNavigateUp(): Boolean {
        statusActivity(true)
        return super.onSupportNavigateUp()
    }

    private fun statusActivity(isActivityLogin: Boolean) {
        this.isActivityLogin = isActivityLogin
        if (isActivityLogin) {
            authButton.setOnClickListener(authListener)
            authButton.setText(R.string.auth)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            fullName.visibility = View.GONE
            newAccount.visibility = View.VISIBLE
            email.requestFocus()
        } else {
            authButton.setOnClickListener(registrationListener)
            authButton.setText(R.string.registr)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            fullName.visibility = View.VISIBLE
            newAccount.visibility = View.GONE
            fullName.requestFocus()
        }
    }
}
