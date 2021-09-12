package com.example.newproject

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
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
        arrMeme.add(Meme("chims1", R.drawable.chims1))
        arrMeme.add(Meme("monke", R.drawable.monke))
        arrMeme.add(Meme("nigga1", R.drawable.nigga1))
        arrMeme.add(Meme("nigga2", R.drawable.nigga2))
        arrMeme.add(Meme("pepe", R.drawable.pepe))
        arrMeme.add(Meme("tom", R.drawable.tom))
        arrMeme.add(Meme("cat", R.drawable.cat))
        arrMeme.add(Meme("dog", R.drawable.dog))
        arrMeme.add(Meme("kermit", R.drawable.kermit))
        arrMeme.add(Meme("lobov", R.drawable.lobov))
        arrMeme.add(Meme("shrek", R.drawable.shrek))



        listView.adapter = RomankovAdapter(applicationContext, arrMeme)




    }

}