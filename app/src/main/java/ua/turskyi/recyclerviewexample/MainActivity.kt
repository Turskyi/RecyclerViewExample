package ua.turskyi.recyclerviewexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    lateinit var adapter: ExampleAdapter
    lateinit var exampleList: MutableList<ExampleItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        generateDummyList()
        initAdapter()
    }

    private fun initAdapter() {
        adapter = ExampleAdapter()
        adapter.setData(exampleList)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun generateDummyList() {
        exampleList = mutableListOf()
        for (i in 0 until 500) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_launcher_foreground
                1 -> R.mipmap.ic_launcher
                else -> R.drawable.ic_launcher_foreground
            }
            val item = ExampleItem(drawable, "Item $i", "Line 2")
            exampleList.plusAssign(item)
        }
    }
}