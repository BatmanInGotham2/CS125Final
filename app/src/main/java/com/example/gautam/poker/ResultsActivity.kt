package com.example.gautam.poker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ResultsActivity : AppCompatActivity() {

    var next: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        next = findViewById<Button>(R.id.button2)
        next?.setOnClickListener {
            val intent = Intent(this@ResultsActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
