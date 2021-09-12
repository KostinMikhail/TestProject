package com.example.newproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.*
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity

class RomankovAdapter(var context: Context, val memeList: ArrayList<Meme>) : BaseAdapter() {


//viewHolder это View(вид, как она выглядит) одной ячейки

    private class ViewHolder(row: View?) {
    //переменные к которым привяжем объекты ячейки
        var txtName: TextView
        var ivImage: ImageView
        var ivImage2: ImageView

// к каждой переменной привязываем объект из XML
        init {  //конструктор
            this.txtName = row?.findViewById(R.id.txtName) as TextView
            this.ivImage = row?.findViewById(R.id.ivMemes) as ImageView
            this.ivImage2 = row?.findViewById(R.id.ivMemes2) as ImageView
        }
    }

    override fun getCount(): Int {
        return memeList.size
    }

    override fun getItem(position: Int): Any {
        return memeList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    interface OnUserClickListener {
        fun onUserClick(meme: Meme?)

    }


    setContentView(R.layout.meme_item_list)

    var listElement = findViewById(R.id.ListView) as Button

        listElement.setOnClickListener(object : View.OnClickListener {
        override fun onClick(view: View): Unit {

            val text = "это тост"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()


        })
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View?
        var viewHolder: ViewHolder
     /*   if (convertView == null) {

        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        } */
        var layout = LayoutInflater.from(context)
        view = layout.inflate(R.layout.activity_main3, parent, false)
        viewHolder = ViewHolder(view)   //создание объекта на основе класса
     //   view.tag = viewHolder

        var meme: Meme = getItem(position) as Meme
        viewHolder.txtName.text = meme.name
        viewHolder.ivImage.setImageResource(meme.image)
        viewHolder.ivImage2.setImageResource(meme.image)

        return view as View
    }

}