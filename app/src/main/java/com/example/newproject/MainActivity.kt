package com.example.newproject

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // подключение к экрану файла activity_main.xml
        setContentView(R.layout.activity_main)
        // var button - создаём переменную button
        // findViewById - внутренний метод андроид в который нужно передать Id элемента, он возвращает объект View
        //as Button - говорит о том, что вернётся кнопка
        var button = findViewById(R.id.showMsg) as Button
        // setOnClickListner - метод, который вызывается у объекта button
        //24-28 запомнить эту конструкцию. эта конструкция нужна для обратоки нажатия объекта button
        button.setOnClickListener(object : View.OnClickListener {
            // метод Onclick вызовится при нажатии объекта button

            override fun onClick(view: View): Unit {
                //метод позволяет написать в лог
                Log.i("TEST", "Это мое сообщение для записи в журнале");

            }
        })


        var button2 = findViewById(R.id.btnNext) as Button

        button2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View): Unit {
                val text = "Hello toast!"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
                toast.setGravity(Gravity.CENTER, 0, 0)
            }})

    /*var button2 = findViewById(R.id.btnNext) as Button
      button2.setOnClickListener(object : View.OnClickListener {
          fun toastMe(view: View) {
              val myToast = Toast.makeText(this@MainActivity, "привет!", Toast.LENGTH_SHORT)
              myToast.show()


          }

  }) */
}
}


