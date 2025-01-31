package com.example.proyecto_2segundotrimestre

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class GalleryPagerAdapter(private val images: List<Int>) : PagerAdapter() {

    override fun getCount(): Int = images.size

    override fun isViewFromObject(view: View, obj: Any): Boolean = view == obj

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(container.context)
        imageView.setImageResource(images[position])
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        container.addView(imageView)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }
}