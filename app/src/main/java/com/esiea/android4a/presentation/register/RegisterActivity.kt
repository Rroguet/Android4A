package com.esiea.android4a.presentation.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.esiea.android4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.android.ext.android.inject


class RegisterActivity : AppCompatActivity() {
    private val registerViewModel : RegisterViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerViewModel.registerLiveData.observe(this, Observer {
            when(it){
                is RegisterSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Success")
                        .setMessage("New account")
                        .setPositiveButton("Ok") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                    finish()
                }
                RegisterError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("Login or password empty")
                        .setPositiveButton("Ok") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        register_button.setOnClickListener {
            registerViewModel.onClickedRegister(login_edit.text.toString().trim(), password_edit.text.toString())
        }

        back_button.setOnClickListener {
            finish()
        }
    }
}