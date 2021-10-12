package com.example.newproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ChuckActivity : AppCompatActivity() {

    val URL = "https://api.icndb.com/jokes/random"
    var okHttpClient: OkHttpClient = OkHttpClient()
    lateinit var factTv: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nextBtn = findViewById(R.id.nextBtn) as Button
        factTv = findViewById(R.id.factTv) as TextView
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
// поменять API, вытащить клоюч иконки, и в имидж вью загрузить иконку  подсказка для гула ->"imageView downlad image"
// перенести в основной проект
                val txt = (JSONObject(json).getJSONObject("value").get("joke")).toString()


                runOnUiThread {
                    progressBar.visibility = View.GONE

                    factTv.text = txt
                }

            }
        })
    }
}















