package com.example.proyecto_2segundotrimestre

import Blog
import Blogadapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BlankFragment4 : Fragment() {

    private val blogs: ArrayList<Blog> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank4, container, false)

        // Initialize blogs
        initializeBlogs()

        // Setup RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = Blogadapter(blogs)
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        return view
    }

    private fun initializeBlogs() {
        // Add your blog data here
        blogs.add(
            Blog(
                "Nueva gira",
                R.drawable.robegira,
                "19 de febrero de 2024",
                "Texto de la noticia 1",
                "Texto de la noticia 2",
                "Texto de la noticia 3",
                R.drawable.img,
                R.drawable.img
            )
        )
        blogs.add(
            Blog(
                "nuevo concierto en Ubeda",
                R.drawable.robegira,
                "19 de marzo de 2024",
                "Texto de la noticia 1",
                "Texto de la noticia 2",
                "Texto de la noticia 3",
                R.drawable.img,
                R.drawable.img
            )
        )
        blogs.add(
            Blog(
                "¿Resurgira la vieja banda?",
                R.drawable.img,
                "23 de diciembre de 2023",
                "Texto de la noticia 1",
                "Texto de la noticia 2",
                "Texto de la noticia 3",
                R.drawable.img,
                R.drawable.img
            )
        )
        blogs.add(
            Blog(
                "Ni santos, ni inocentes",
                R.drawable.gir,
                "25 de octubre de 2023",
                "Texto de la noticia 1",
                "Texto de la noticia 2",
                "Texto de la noticia 3",
                R.drawable.img,
                R.drawable.img
            )
        )
        blogs.add(
            Blog(
                "El poder del arte",
                R.drawable.robesenosllevaelaire,
                "13 de septiembre de 2023",
                "Texto de la noticia 1",
                "Texto de la noticia 2",
                "Texto de la noticia 3",
                R.drawable.img,
                R.drawable.img
            )
        )
        blogs.add(
            Blog(
                "Tomas",
                R.drawable.img,
                "23 de agosto de 2023",
                "Texto de la noticia 1",
                "Texto de la noticia 2",
                "Texto de la noticia 3",
                R.drawable.img,
                R.drawable.img
            )
        )



    }
}