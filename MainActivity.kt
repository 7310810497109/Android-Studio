package com.example.linearactivitylayout

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var emailEdt : EditText
    private lateinit var passwordEdt : EditText
    private lateinit var buttonSubmit : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_linear_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        emailEdt = findViewById(R.id.edt_email)
        passwordEdt = findViewById(R.id.edt_password)
        buttonSubmit = findViewById(R.id.btn_submit)

        buttonSubmit.setOnClickListener {
            val dataEmailEdt = emailEdt.text.toString().trim()
            val dataPasswordEdt = passwordEdt.text.toString().trim()

            if (dataEmailEdt.isEmpty() || dataPasswordEdt.isEmpty()) {
                Toast.makeText(this, "Password atau email Tidak Boleh Kosong", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "Selamat Datang : $dataEmailEdt", Toast.LENGTH_SHORT).show()
            }
        }
    }
}