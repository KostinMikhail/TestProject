package com.example.newproject

import android.app.DownloadManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import java.util.*


class ChuckActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chuck)

        val textView = findViewById<TextView>(R.id.text)
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.chucknorris.io/"
        val stringRequest = StringRequest(
            DownloadManager.Request.Method.GET, url,
            Response.Listener<String> { response ->
                                textView.text = "Response is: ${response.substring(0, 500)}"
            },
            Response.ErrorListener { textView.text = "notWorking" })

// Add the request to the RequestQueue.
        queue.add(stringRequest)





    }
}