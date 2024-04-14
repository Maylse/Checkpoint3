package com.example.exampleapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        val names = arrayOf("Ivan", "Brylle", "Rem", "Ram", "Anthony")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)

        listView.adapter = adapter

        val nextButton = findViewById<Button>(R.id.toCustomListView)
        nextButton.setOnClickListener{
            val intent = Intent(this, CustomListView::class.java)
            startActivity(intent)
        }
    }
}