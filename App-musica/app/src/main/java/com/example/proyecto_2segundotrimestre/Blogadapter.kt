import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_2segundotrimestre.R

class Blogadapter(private val blogs: List<Blog>) : RecyclerView.Adapter<Blogadapter.BlogViewHolder>() {

    inner class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewMain: ImageView = itemView.findViewById(R.id.imageViewMain)
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_blog, parent, false)
        return BlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val blog = blogs[position]
        holder.imageViewMain.setImageResource(blog.mainImage)
        holder.textViewTitle.setText(blog.title)
        holder.textViewDate.setText(blog.date)

        // Set click listener to handle item click
        holder.itemView.setOnClickListener {
            // Handle item click here, you can pass the blog data to the next activity/fragment
        }
    }

    override fun getItemCount(): Int {
        return blogs.size
    }
}