package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Button
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SP_INFO", MODE_PRIVATE)

        val SaveBtn = findViewById<Button>(R.id.SaveBtn)
        val ShowInfoBtn = findViewById<Button>(R.id.ShowInfoBtn)
        val Name = findViewById<TextView>(R.id.Name)
        val Rate = findViewById<TextView>(R.id.Rate)
        val ShowInfo = findViewById<TextView>(R.id.ShowInfo)
        val Switch = findViewById<Switch>(R.id.Switch)

        SaveBtn.setOnClickListener(){
            val name = Name.text.toString().trim()
            val rate = Integer.parseInt(Rate.text.toString().trim())
            val satisfactionLevel = Switch.isChecked

            val editor = sharedPreferences.edit()
            editor.putString("NAME", name)
            editor.putInt("RATE", rate)
            editor.putBoolean("SATISFACTION", satisfactionLevel)

            editor.apply()
        }

        ShowInfoBtn.setOnClickListener(){
            val name = sharedPreferences.getString("NAME", "")
            val rate = sharedPreferences.getInt("RATE", 0)
            val satisfactionLevel = sharedPreferences.getBoolean("SATISFACTION", false)

            ShowInfo.text = "Name : $name \nRate: $rate \nSatisfaction: $satisfactionLevel"

        }
    }
}