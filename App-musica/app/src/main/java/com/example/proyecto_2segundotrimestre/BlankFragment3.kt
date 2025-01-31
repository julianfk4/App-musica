package com.example.proyecto_2segundotrimestre

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AlertDialog

class BlankFragment3 : Fragment() {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextMessage: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank3, container, false)

        // Referencias a las vistas
        editTextName = view.findViewById(R.id.editTextName)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        editTextMessage = view.findViewById(R.id.editTextMessage)

        // Botones de contacto
        view.findViewById<Button>(R.id.buttonEmail).setOnClickListener {
            sendEmail()
        }

        view.findViewById<Button>(R.id.buttonPhone).setOnClickListener {
            callCenter()
        }

        view.findViewById<Button>(R.id.buttonLocation).setOnClickListener {
            openGoogleMaps()
        }

        view.findViewById<Button>(R.id.buttonWhatsApp).setOnClickListener {
            openWhatsApp()
        }

        // Botón de enviar mensaje
        view.findViewById<Button>(R.id.buttonSend).setOnClickListener {
            validateAndSend()
        }

        return view
    }

    private fun sendEmail() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:info@escuelaestech.es,secretaria@escuelaestech.es")
        }
        startActivity(intent)
    }

    private fun callCenter() {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:123456789") // Reemplaza esto con el número de teléfono real
        }
        startActivity(intent)
    }

    private fun openGoogleMaps() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://maps.google.com/?q=Tu+centro")
        }
        startActivity(intent)
    }

    private fun openWhatsApp() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://wa.me/123456789") // Reemplaza esto con el número de WhatsApp real
        }
        startActivity(intent)
    }

    private fun validateAndSend() {
        val name = editTextName.text.toString()
        val email = editTextEmail.text.toString()
        val message = editTextMessage.text.toString()

        if (name.isNotEmpty() && email.isNotEmpty() && isValidEmail(email) && message.isNotEmpty()) {
            showConfirmationDialog(name, email, message)
        } else {
            // Mostrar mensaje de error
            // Por ejemplo, Toast.makeText(requireContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidEmail(email: String): Boolean {
        // Comprobar el formato del correo electrónico
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun showConfirmationDialog(name: String, email: String, message: String) {
        AlertDialog.Builder(requireContext())
            .setMessage("¿Estás seguro de enviar el mensaje?")
            .setPositiveButton("Sí") { _, _ ->
                sendEmailWithContent(name, email, message)
            }
            .setNegativeButton("No", null)
            .show()
    }

    private fun sendEmailWithContent(name: String, email: String, message: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("info@escuelaestech.es", "secretaria@escuelaestech.es"))
            putExtra(Intent.EXTRA_SUBJECT, "Mensaje de $name")
            putExtra(Intent.EXTRA_TEXT, "Nombre: $name\nCorreo electrónico: $email\nMensaje: $message")
        }
        startActivity(Intent.createChooser(intent, "Enviar correo"))
    }
}