package com.example.newproject

import android.app.DownloadManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Response
import com.example.newproject.repository.Repository
import java.util.*


class ChuckActivity: AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chuck)

    val repository = Repository()
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


    }
}