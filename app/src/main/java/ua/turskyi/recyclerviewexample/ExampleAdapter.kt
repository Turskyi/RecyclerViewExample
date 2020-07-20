package ua.turskyi.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_example.view.*

class ExampleAdapter : ListAdapter<ExampleItem ,ExampleAdapter.ExampleViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<ExampleItem> =
            object : DiffUtil.ItemCallback<ExampleItem>() {
                override fun areItemsTheSame(oldItem: ExampleItem, newItem: ExampleItem): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: ExampleItem, newItem: ExampleItem): Boolean {
                    return oldItem.imgRes == newItem.imgRes &&
                            oldItem.text1 == newItem.text1 &&
                            oldItem.text2 == newItem.text2
                }
            }
    }
    var onItemClickListener: ((item: ExampleItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ExampleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_example,
                parent, false
            )
        )

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = getItem(position)
        currentItem?.run {
            holder.imageView.setImageResource(imgRes)
            holder.textView1.text = text1
            holder.textView2.text = text2
        }
    }

    inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.iv
        val textView1: TextView = itemView.tv1
        val textView2: TextView = itemView.tv2

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition)
                    ?.let { exampleItem -> onItemClickListener?.invoke(exampleItem) }
            }
        }
    }
}