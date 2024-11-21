package com.ssldevteam.lavandaapp.frames

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.ssldevteam.lavandaapp.R

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Configurar ajustes de diseño
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Referencias a los campos de entrada y botón
        val emailField = findViewById<EditText>(R.id.txtEmail2)
        val passwordField = findViewById<EditText>(R.id.txtContraseña2)
        val registerButton = findViewById<Button>(R.id.btnLogin2)

        // Listener del botón de registro
        registerButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            if (validateInputs(email, password)) {
                registerUser(email, password)
            }
        }
    }

    // Validar los campos de entrada
    private fun validateInputs(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa un correo.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Por favor, ingresa un correo válido.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa una contraseña.", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password.length < 6) {
            Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres.", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    // Registrar al usuario con Firebase
    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Registro exitoso
                    Toast.makeText(this, "Registro exitoso.", Toast.LENGTH_SHORT).show()

                    // Redirigir a la actividad principal
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Error en el registro
                    Toast.makeText(this, "Error al registrarse: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
