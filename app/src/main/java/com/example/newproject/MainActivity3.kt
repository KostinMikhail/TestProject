package com.example.newproject

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlin.collections.List as List1


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.newproject.R.layout.activity_main3)

        val listView: ListView = findViewById(com.example.newproject.R.id.ListView)
        val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val adapter: ArrayAdapter<Any?> = ArrayAdapter<Any?>(this, R.layout.simple_list_item_1, numbers)

        listView.adapter = adapter









    }
}