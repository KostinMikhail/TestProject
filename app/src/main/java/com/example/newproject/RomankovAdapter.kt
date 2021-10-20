package com.example.newproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.util.*


class RomankovAdapter(var context: Context, val memeList: ArrayList<Meme>) : BaseAdapter() {



    private class ViewHolder(row: View?) {
        var txtName: TextView
        var ivMemes: ImageView
        var ivMemes2: ImageView

        init {
            this.txtName = row?.findViewById(R.id.txtName) as TextView
            this.ivMemes = row?.findViewById(R.id.ivMemes) as ImageView
            this.ivMemes2 = row?.findViewById(R.id.ivMemes2) as ImageView

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

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.activity_main3, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var meme: Meme = getItem(position) as Meme
        viewHolder.txtName.text = meme.name
        viewHolder.ivMemes.setImageResource(meme.image)
        viewHolder.ivMemes2.setImageResource(meme.image)
        Picasso.with(this.context)
            .load(meme.urlImage)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .into(viewHolder.ivMemes)
        return view as View
    }

}