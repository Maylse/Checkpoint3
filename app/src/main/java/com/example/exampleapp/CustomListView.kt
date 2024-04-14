package com.example.exampleapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView

class CustomListView : AppCompatActivity() {
    val fruitList = arrayOf("Apple", "Banana", "Orange")
    val fruitImages = intArrayOf(R.drawable.apple, R.drawable.banana, R.drawable.orange)
    var listView: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        supportActionBar?.hide();

        setContentView(R.layout.activity_custom_list_view)
        listView = findViewById<ListView>(R.id.customlistView)
        val customBaseAdapter = CustomBaseAdapter(applicationContext, fruitList, fruitImages)
        listView?.adapter = customBaseAdapter;
        listView?.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id
            -> Log.i("CUSTOMER_LIST_VIEW", "Item is clicked @ Position :: $position")
        }

        val nextButton = findViewById<Button>(R.id.toRecycleListView)
        nextButton.setOnClickListener{
            val intent = Intent(this, RecyclerView::class.java)
            startActivity(intent)
        }
    }
}