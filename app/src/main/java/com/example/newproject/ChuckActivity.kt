package com.example.newproject

import android.app.DownloadManager
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.android.volley.Response
import com.example.newproject.repository.Repository
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import org.json.JSONObject
import java.io.IOException
import java.util.*


class ChuckActivity: AppCompatActivity() {

 //   private lateinit var viewModel: MainViewModel

    val URL = "https://api.chucknorris.io/jokes/random"
    var okHttpClient: OkHttpClient = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chuck)

        var jokeBtn = findViewById(R.id.jokeBtn) as Button //Этой строчки почему-то в видео тоже не было, кнопка сразу начала выпонлять методы. почему?
        jokeBtn.setOnClickListener {
            loadRandomFact ()
        }



        fun loadRandomFact () {
            runOnUiThread {
                progressBar.visibility = View.VISIBLE
            }
            val request: Request = Request.Builder().url(URL).build()
            okHttpClient.newCall(request).enqueue(object: Callback {
                override fun onFailure(call: Call?, e: IOException) {
                }

                override fun onResponse(call: Call?, response: okhttp3.Response?) {
                    val json = response?.body()?.string()
                    val txt  = (JSONObject(json).getJSONObject("value").get("joke")).toString()

                    runOnUiThread {
                        progressBar.visibility = View.GONE
                        textView2.text = Html.fromHtml(txt)
                    }
                }
            })
        }
















  /*  val repository = Repository()
    val viewModelFactory = MainViewModelFactory(repository)
    val textView : TextView = findViewById(R.id.textView) as TextView //Этого не было в видео, но я добавил, т.к. хз, как он создаёт текствьюху и потом вызывает её
    viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    viewModel.getPost()
    viewModel.myResponse.observe(this, androidx.lifecycle.Observer { response ->
        if(response.isSuccessful){
            Log.d("Response", response.body()?.userID.toString())
            Log.d("Response", response.body()?.id.toString())
            textView.text = response.body()?.title!!
            Log.d("Response", response.body()?.body!!)
        }else{
            Log.d("Response", response.errorBody().toString())
            textView.text = response.code().toString()
        }




    })
*/
    }
}