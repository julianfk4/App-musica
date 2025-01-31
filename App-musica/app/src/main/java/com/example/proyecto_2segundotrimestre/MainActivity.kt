package com.example.proyecto_2segundotrimestre

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyecto_2segundotrimestre.databinding.DespleBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: DespleBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DespleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView3) as NavHost
        navController = navHost.navController
        val extras = intent.extras

        // Verificar si hay extras y recuperarlos si existen
        if (extras != null) {
            val data =
                extras.getString("key") // Reemplaza "key" con la clave que usaste para enviar los datos desde ActivityA
            val bundle = Bundle().apply {
                putString("username", data.toString())
            }

            val fragment = BlankFragment()
            fragment.arguments = bundle

            supportFragmentManager.beginTransaction()
                .replace(R.id.f1text, fragment) // Reemplaza R.id.container con el ID del contenedor adecuado
                .commit()
        }


        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.inicio,
                R.id.galeria,
                R.id.contacto,
                R.id.blog
            ), binding.drawerLayout
        )



        setupActionBarWithNavController(navController, appBarConfiguration)



        binding.drawernavigat.setupWithNavController(navController)
        navController.addOnDestinationChangedListener{_,destination,_ ->
            supportActionBar?.title = when(destination.id){
                R.id.inicio -> "inicio"
                R.id.galeria -> "blog"
                R.id.contacto -> "contacto"
                R.id.blog -> "blog"
                else -> title
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp( navController, null )
    }
/*
    override fun onSupportNavigateUp() = NavController.navigateup(appBarConfiguration)
 */


}





/*
    override fun onDestroy() {
        super.onDestroy()
        // Liberar recursos del reproductor de medios al cerrar la aplicación
        mediaPlayer.release()
    }
}
/*
Glide.with(this)
.load("")
.into(binding.imagen)
*/*/
