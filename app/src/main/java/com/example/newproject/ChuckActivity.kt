package com.example.newproject

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import com.squareup.picasso.Picasso

class ChuckActivity : AppCompatActivity() {

    val URL = "https://api.chucknorris.io/jokes/random"
    var okHttpClient: OkHttpClient = OkHttpClient()
    lateinit var factTv: TextView
    lateinit var img: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chuck_activity)
        var nextBtn = findViewById(R.id.nextBtn) as Button
        factTv = findViewById(R.id.factTv) as TextView

        img = findViewById(R.id.imageView) as ImageView

        nextBtn.setOnClickListener{
            loadRandomFact()
        }
    }

    private fun loadRandomFact(){
        var progressBar = findViewById(R.id.progressBar) as ProgressBar
        runOnUiThread {
            progressBar.visibility = View.VISIBLE
        }

        val request: Request = Request.Builder().url(URL).build()
        okHttpClient.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body?.string()


                val txt = (JSONObject(json).get("value")).toString() //было написано   val txt = (JSONObject(json).getJSONObject("value").get("value")).toString() почему я изменил и заработало?
                val URLimg = (JSONObject(json).get("icon_url")).toString()


                runOnUiThread {
                    progressBar.visibility = View.GONE
                    Picasso.with(this@ChuckActivity)
                        .load (URLimg)
                        .into(img)
                    factTv.text = txt
                }

            }
        })
    }
}