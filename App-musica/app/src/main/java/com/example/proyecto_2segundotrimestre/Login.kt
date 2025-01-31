package com.example.proyecto_2segundotrimestre

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.InputType
import android.util.Patterns
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.proyecto_2segundotrimestre.databinding.LoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: LoginBinding

    private val credentials = mapOf(
        "invitado" to "estech1234",
        "alumno" to "alumno1234",
        "profesor" to "profesor1234"
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editTextUsername = binding.getUser
        val editTextPassword = binding.getPassword
        val checkBoxShowPassword = binding.checkBox
        val buttonLogin = binding.botonRegistro
        val username = binding.getUser


        checkBoxShowPassword.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                editTextPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                editTextPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", "value")
            if (credentials.containsKey(username) && credentials[username] == password) {
                // Inicio de sesión exitoso, guardar el nombre de usuario en las preferencias compartidas
                val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("username", username)
                editor.apply()

                // Iniciar la actividad principal
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Finalizar la actividad de inicio de sesión para que el usuario no pueda volver a ella
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
        fun callHelpCenter() {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:111111111")
            ContextCompat.startActivity(this, intent, null)
        }
        binding.llamanos.setOnClickListener {
            callHelpCenter()
        }
        checkBoxShowPassword.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_remind_password, null)
            val editTextEmail = dialogView.findViewById<EditText>(R.id.editTextEmail)

            val builder = AlertDialog.Builder(this)
                .setTitle("Recordar Contraseña")
                .setView(dialogView)
                .setPositiveButton("Enviar") { dialog, _ ->
                    val email = editTextEmail.text.toString().trim()
                    if (isValidEmail(email)) {
                        // Aquí podrías enviar el correo electrónico al servidor para restablecer la contraseña
                        Toast.makeText(this, "Correo electrónico enviado a: $email", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Por favor, introduce un correo electrónico válido", Toast.LENGTH_SHORT).show()
                    }
                    dialog.dismiss()
                }
                .setNegativeButton("Cancelar") { dialog, _ ->
                    dialog.dismiss()
                }

            val dialog = builder.create()
            dialog.show()
        }




    }
    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    }

