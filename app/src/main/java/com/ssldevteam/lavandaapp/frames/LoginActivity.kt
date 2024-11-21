package com.ssldevteam.lavandaapp.frames

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.ssldevteam.lavandaapp.R

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var btnLogin: Button
    private lateinit var txtEmail: EditText
    private lateinit var txtPassword: EditText
    private lateinit var lblRegistroAct: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializar Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Enlazar los elementos de la vista
        btnLogin = findViewById(R.id.btnLogin)
        txtEmail = findViewById(R.id.txtEmail)
        txtPassword = findViewById(R.id.txtContraseña)
        lblRegistroAct = findViewById(R.id.lblRegistroAct)

        // Configurar el botón de inicio de sesión
        btnLogin.setOnClickListener {
            loginUser()
        }

        // Configurar el TextView para ir a RegisterActivity
        lblRegistroAct.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser() {
        val email = txtEmail.text.toString()
        val password = txtPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            showToast("Por favor, completa todos los campos")
            return
        }

        // Iniciar sesión con email y contraseña
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Inicio de sesión exitoso
                    showToast("¡Inicio de sesión exitoso!")
                    val intent = Intent(this, HomeClient::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Inicio de sesión fallido
                    showToast("Inicio de sesión fallido. Verifica tus datos.")
                }
            }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
