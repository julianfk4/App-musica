import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_2segundotrimestre.R

class ThumbnailAdapter(
    private val images: List<Int>,
    private val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<ThumbnailAdapter.ThumbnailViewHolder>() {

    inner class ThumbnailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageThumbnail: ImageView = itemView.findViewById(R.id.imageThumbnail)

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_thumbnail, parent, false)
        return ThumbnailViewHolder(view)
    }

    override fun onBindViewHolder(holder: ThumbnailViewHolder, position: Int) {
        holder.imageThumbnail.setImageResource(images[position])
    }

    override fun getItemCount(): Int = images.size
}