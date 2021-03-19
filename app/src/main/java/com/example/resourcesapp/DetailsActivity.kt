package com.example.resourcesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val userName = intent.getStringExtra("userName")

        findViewById<TextView>(R.id.tvDetailsMessage).text = userName
    }
}