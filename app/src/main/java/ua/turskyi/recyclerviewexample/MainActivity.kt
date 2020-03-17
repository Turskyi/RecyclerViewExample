package ua.turskyi.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val exampleList = 500.generateDummyList()
        recycler_view.adapter = ExampleAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun Int.generateDummyList(): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until this) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_launcher_foreground
                1 -> R.mipmap.ic_launcher
                else -> R.drawable.ic_launcher_foreground
            }
            val item = ExampleItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }
}