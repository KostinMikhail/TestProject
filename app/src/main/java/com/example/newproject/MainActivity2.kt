package com.example.newproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var button4 = findViewById(R.id.btnList) as Button

        button4.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View): Unit {

                val intent = Intent(this@MainActivity2, MainActivity3 ::class.java)
                startActivity(intent)
            }
        })



    }
}