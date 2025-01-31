package com.example.proyecto_2segundotrimestre

import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_2segundotrimestre.databinding.FragmentBlankBinding



class BlankFragment : Fragment() {
    private var logoClickCount = 0
    private var easterEggEnabled = true
    private lateinit var username: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño del fragmento
        val view = inflater.inflate(R.layout.fragment_blank, container, false)

        // Obtener el nombre de usuario de los argumentos del fragmento
        val username = arguments?.getString("username")

        // Configurar el mensaje de bienvenida
        view.findViewById<TextView>(R.id.f1text).text = ("¡Bienvenido, $username!")

        // Configurar la Toolbar con el menú de opciones
        val toolbar: Toolbar = view.findViewById(R.id.f1toolbar)
        toolbar.inflateMenu(R.menu.menu_logout)
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.fuera -> { // Cambiado a R.id.menu_logout
                    showLogoutConfirmationDialog()
                    true
                }
                else -> false
            }
        }

        // Listener para el logo
        val logoImageView: ImageView = view.findViewById(R.id.logoImageView)
        logoImageView.setOnClickListener {
            if (easterEggEnabled) {
                logoClickCount++
                if (logoClickCount == 10) {
                    showEasterEggDialog()
                }
            }
        }

        return view
    }

    private fun showLogoutConfirmationDialog() {
        AlertDialog.Builder(requireContext())
            .setMessage("¿Está seguro de que desea cerrar sesión?")
            .setPositiveButton("Sí") { _, _ ->
                logoutAndOpenLoginActivity()
            }
            .setNegativeButton("No", null)
            .show()
    }

    private fun logoutAndOpenLoginActivity() {
        // Código para cerrar sesión y abrir LoginActivity
        val intent = Intent(requireContext(), Login::class.java)
        startActivity(intent)
        requireActivity().finishAffinity() // Finalizar todas las actividades de la aplicación
    }

    private fun showEasterEggDialog() {
        // Código para mostrar el cuadro de diálogo del huevo de pascua
        AlertDialog.Builder(requireContext())
            .setMessage("¿Está seguro de que desea cerrar sesión?")
            .setPositiveButton("Sí") { _, _ ->
                logoutAndOpenLoginActivity()
            }
            .setNegativeButton("No", null)
            .show()
    }
}