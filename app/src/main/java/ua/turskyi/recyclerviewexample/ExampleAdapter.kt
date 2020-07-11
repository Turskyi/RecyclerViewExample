package ua.turskyi.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_example.view.*

class ExampleAdapter : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {
    var onItemClickListener: ((item: ExampleItem) -> Unit)? = null
    var exampleList: MutableList<ExampleItem>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ExampleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_example,
                parent, false
            )
        )

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList?.get(position)
        currentItem?.run {
            holder.imageView.setImageResource(imgRes)
            holder.textView1.text = text1
            holder.textView2.text = text2
        }
    }

    override fun getItemCount(): Int = exampleList?.size ?: 0

    inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.iv
        val textView1: TextView = itemView.tv1
        val textView2: TextView = itemView.tv2

        init {
            itemView.setOnClickListener {
                exampleList?.get(bindingAdapterPosition)
                    ?.let { exampleItem -> onItemClickListener?.invoke(exampleItem) }
            }
        }
    }
}