package ua.turskyi.recyclerviewexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    lateinit var adapter: ExampleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initListener()
    }

    private fun initListener() {
        adapter.onItemClickListener = ::invoke
    }

    private fun invoke(item: ExampleItem) =
        Toast.makeText(this, "${item.text1} ${item.text2}", Toast.LENGTH_SHORT).show()

    private fun initView() = initAdapter()

    private fun initAdapter() {
        adapter = ExampleAdapter()
        adapter.submitList(generateDummyList())
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
    }

    private fun generateDummyList(): MutableList<ExampleItem> {
        val exampleList: MutableList<ExampleItem> = mutableListOf()
        for (i in 0 until 500) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_launcher_foreground
                1 -> R.mipmap.ic_launcher
                else -> R.drawable.ic_launcher_foreground
            }
            val item = ExampleItem(drawable, "Item $i", "Line 2")
            exampleList.plusAssign(item)
        }
        return exampleList
    }
}