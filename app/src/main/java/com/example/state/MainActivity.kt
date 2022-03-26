package com.example.state

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

const val KEY_COUNTER = "COUNTER"

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var counter: Int = 0;

    private lateinit var text: TextView;
    private lateinit var button: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text)
        button = findViewById(R.id.button)

        button.setOnClickListener(this)

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNTER)
        }

        text.text = counter.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_COUNTER, counter)
    }

    override fun onClick(p0: View?) {
        counter++
        text.text = counter.toString()
    }
}