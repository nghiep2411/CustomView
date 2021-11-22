
package com.example.customview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnSeekBar : Button
    lateinit var btn2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSeekBar = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)

        btnSeekBar.setOnClickListener {
            val intent = Intent(this,SeekbarActivity::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            val intent = Intent(this,ProgressBarActivity::class.java)
            startActivity(intent)
        }
    }

    fun openSinner(view: android.view.View) {
        val intent = Intent(this,SpinnerActivity::class.java)
        startActivity(intent)
    }

    fun openCheckBox(view: android.view.View) {
        val intent = Intent(this,CheckBoxActivity::class.java)
        startActivity(intent)
    }
}