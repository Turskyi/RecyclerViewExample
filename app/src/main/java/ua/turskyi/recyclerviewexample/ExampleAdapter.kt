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
    private val exampleList: MutableList<ExampleItem> = mutableListOf()
    fun setData(newExampleList: MutableList<ExampleItem>) {
        this.exampleList.clear()
        this.exampleList.addAll(newExampleList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_example,
            parent, false
        )
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.imageView.setImageResource(currentItem.imgRes)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
    }

    override fun getItemCount() = exampleList.size

    inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.iv
        val textView1: TextView = itemView.tv1
        val textView2: TextView = itemView.tv2

        init {
            itemView.setOnClickListener {
                onItemClickListener?.invoke(exampleList[adapterPosition])
            }
        }
    }
}