package com.example.proyecto_2segundotrimestre

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.proyecto_2segundotrimestre.databinding.HolderBinding

class Adaptador(private val Listado: ArrayList<Persona>) : Adapter<Adaptador.ClaseCelda>(){
    private var mediaPlayer = MediaPlayer()

    inner class ClaseCelda(val binding: HolderBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaseCelda {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HolderBinding.inflate(inflater, parent, false)
        return ClaseCelda(binding)
    }

    override fun getItemCount(): Int {
        return Listado.size
    }

    override fun onBindViewHolder(holder: ClaseCelda, position: Int) {
        val persona = Listado[position]
        with(holder.binding){
            texto.text = persona.nombre
            boton.text = persona.apellidos
        }
        holder.binding.texto.text = persona.nombre
        //holder.binding.imagen.setImageResource(persona.imagen)
        Glide.with(holder.itemView).load(persona.imagen).into(holder.binding.imagen)
        holder.binding.boton.setOnClickListener {

        }
    }
    private fun playSound() {
        // Verificar si el reproductor está en modo de reproducción
        if (mediaPlayer.isPlaying) {
            // Si está reproduciendo, detener la reproducción
            mediaPlayer.stop()
        }
        // Volver a iniciar la reproducción desde el principio
        mediaPlayer.seekTo(0)
        mediaPlayer.start()
    }}
