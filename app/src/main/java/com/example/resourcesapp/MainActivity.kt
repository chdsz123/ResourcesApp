package com.example.resourcesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var etUserName: EditText
    private lateinit var btnSubmit: Button
    private lateinit var tvMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())


        bindViews()
    }

    private fun bindViews() {
        etUserName = findViewById(R.id.etUserName)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvMessage = findViewById(R.id.tvMessage)

        tvMessage.visibility = View.GONE

        btnSubmit.setOnClickListener { onSubmitClicked() }
    }

    private fun onSubmitClicked() {
        val userName = etUserName.text.toString()
        Log.d("MainActivity_TAG:", "onSubmitClicked: userName: $userName")
        tvMessage.visibility = View.VISIBLE
        tvMessage.text = getString(R.string.user_name_message_format, userName)
    }

    fun goToDetailsButtonClicked(view: View) {
        Log.d("MainActivity_TAG:", "goToDetailsButtonClicked: $view")

        val intent = Intent(this, DetailsActivity::class.java)

        val userName = etUserName.text.toString()
        intent.putExtra("userName", userName)

        startActivity(intent)
    }
}