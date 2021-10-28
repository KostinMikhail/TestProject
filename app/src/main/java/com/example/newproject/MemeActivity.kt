package com.example.newproject

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MemeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meme_item_list)

        var listView = findViewById(R.id.ListView) as ListView
        var arrMeme: ArrayList<Meme> = ArrayList()
        arrMeme.add(Meme("chims1", R.drawable.chims1, "https://i.imgur.com/md1pbW6.jpg"))
        arrMeme.add(Meme("monke", R.drawable.monke, "https://i.imgur.com/md1pbW6.jpg"))
        arrMeme.add(Meme("nigga1", R.drawable.nigga1, "https://i.imgur.com/md1pbW6.jpg"))
        arrMeme.add(Meme("nigga2", R.drawable.nigga2, "https://i.imgur.com/md1pbW6.jpg"))
        arrMeme.add(Meme("pepe", R.drawable.pepe, "https://i.imgur.com/md1pbW6.jpg"))
        arrMeme.add(Meme("tom", R.drawable.tom, "https://i.imgur.com/md1pbW6.jpg"))

        listView.adapter = RomankovAdapter(applicationContext, arrMeme)

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val text = "Hello toast!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }

    }
}
//написать новый активити, листвью и адаптер