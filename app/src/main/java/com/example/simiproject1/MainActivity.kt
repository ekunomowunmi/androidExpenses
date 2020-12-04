package com.example.simiproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save.setOnClickListener {
            var textView:TextView = findViewById(R.id.income)
            var income = textView.text.toString()
            var intent = Intent(this, ExpensesActivity::class.java)
            intent.putExtra("TOTAL_INCOME",income)
            startActivity(intent)
        }

    }
}