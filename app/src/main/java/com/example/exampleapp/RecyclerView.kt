package com.example.exampleapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerView : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        imageId = arrayOf(
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.orange
        )
        heading = arrayOf(
            "Apples tops the ranking for the most eaten fruits from FruitsTV.",
            "Bananas tops the ranking for the most eaten fruits from FruitsTV.",
            "Oranges tops the ranking for the most eaten fruits from FruitsTV."
        )


        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<News>()
        getUserData()

    }
    private fun getUserData()
    {
        for(i in imageId.indices){
            val news = News(imageId[i], heading[i])
            newArrayList.add(news)
        }
        newRecyclerView.adapter = MyAdapter(newArrayList)
    }

}