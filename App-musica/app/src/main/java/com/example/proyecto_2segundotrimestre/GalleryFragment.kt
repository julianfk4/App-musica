package com.example.proyecto_2segundotrimestre

import ThumbnailAdapter
import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.proyecto_2segundotrimestre.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    private lateinit var binding: FragmentGalleryBinding
    private lateinit var viewPager: ViewPager
    private lateinit var recyclerViewThumbnails: RecyclerView
    private var mediaPlayer: MediaPlayer? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)

        // Inicializar ViewPager
        viewPager = binding.viewPager

        // Inicializar RecyclerView
        recyclerViewThumbnails = binding.recyclerViewThumbnails

        // Configurar ViewPager
        val images = listOf(
            R.drawable.img,
            R.drawable.irostodosatomarporculo,
            R.drawable.loquealeteaennuestrascabezas,
            R.drawable.materialdefectuoso,
            R.drawable.robesenosllevaelaire,
            R.drawable.rocktrnsgres,
            R.drawable.dondeestanmisamigos
        )
        val adapter = GalleryPagerAdapter(images)
        viewPager.adapter = adapter

        // Configurar RecyclerView horizontal
        val layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewThumbnails.layoutManager = layoutManager
        val thumbnailAdapter = ThumbnailAdapter(images) { position ->
            // Manejar clic en una imagen pequeña
            viewPager.currentItem = position
        }
        recyclerViewThumbnails.adapter = thumbnailAdapter

        // Configurar MediaPlayer
        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.tomas)

        binding.floatingActionButton3.setOnClickListener {
            playSound()
        }

        return binding.root
    }

    private fun playSound() {
        // Determinar qué sonido reproducir según la posición actual del ViewPager
        val currentItem = viewPager.currentItem
        val soundResource = when (currentItem) {
            0 -> R.raw.tomas // Sonido para la primera imagen
            1 -> R.raw.corre // Sonido para la segunda imagen
            2 -> R.raw.guerrero
            3 -> R.raw.tango
            4 -> R.raw.poder
            5 -> R.raw.jesus
            6 -> R.raw.pepe
            else -> R.raw.extre // Sonido predeterminado para otras imágenes
        }

        // Crear un nuevo MediaPlayer con el recurso de sonido actual
        val newMediaPlayer = MediaPlayer.create(requireContext(), soundResource)

        // Si el MediaPlayer actual está reproduciendo, detener la reproducción
        if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
            mediaPlayer!!.pause()
            mediaPlayer!!.seekTo(0) // Retroceder al principio del sonido
            mediaPlayer!!.pause()
        }else{

        // Liberar recursos del MediaPlayer actual
        mediaPlayer?.release()

        // Asignar el nuevo MediaPlayer al miembro de la clase
        mediaPlayer = newMediaPlayer

        // Iniciar la reproducción del nuevo sonido
        mediaPlayer!!.start()
    }}
}