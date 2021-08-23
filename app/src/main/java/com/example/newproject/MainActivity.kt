package com.example.newproject

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
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
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        var btnNext = findViewById<View>(R.id.btnNext) as Button
        btnNext.setOnClickListener(this);
        
        return true
    }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}