package com.example.newproject

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import java.util.*

class MemeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meme_item_list)
//сделать один URL в каждую ячейку
        var listView = findViewById(R.id.ListView) as ListView
        var arrMeme: ArrayList<Meme> = ArrayList()

        var imageViewChims = findViewById(R.id.imageViewChims) as ImageView

        Picasso.with(this)
            .load("https://static.wikia.nocookie.net/dogelore/images/8/87/411.png/revision/latest?cb=20200330152532")
            .placeholder(R.drawable.chims_background)
            .error(R.drawable.error)
            .into(imageViewChims)


        arrMeme.add(Meme("chims1", R.drawable.image_view_chims))
        arrMeme.add(Meme("monke", R.drawable.monke))
        arrMeme.add(Meme("nigga1", R.drawable.nigga1))
        arrMeme.add(Meme("nigga2", R.drawable.nigga2))
        arrMeme.add(Meme("pepe", R.drawable.pepe))
        arrMeme.add(Meme("tom", R.drawable.tom))

        listView.adapter = RomankovAdapter(applicationContext, arrMeme)

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val text = "привет"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }

    }
}