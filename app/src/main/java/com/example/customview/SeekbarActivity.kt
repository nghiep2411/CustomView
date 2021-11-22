package com.example.customview

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.drawable.BitmapDrawable
import android.widget.SeekBar
import android.content.res.ColorStateList
import android.widget.TextView
import android.widget.Toast

import android.widget.SeekBar.OnSeekBarChangeListener





class SeekbarActivity : AppCompatActivity() {

    lateinit var seekbar : SeekBar
    lateinit var tvProgress : TextView
    lateinit var tvDuration : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seekbar)
        seekbar = findViewById(R.id.seekBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvDuration = findViewById(R.id.tvDuration)

        
        tvProgress.text = "00:00"

        seekbar.max=200
        tvDuration.text = convertToMinute(seekbar.max)
        
        seekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                tvProgress.text = convertToMinute(progress)
            }
        })


    }

    fun convertToMinute(progress : Int) : String {
        val minute = progress/60
        val second = progress%60
        val timeString = String.format("%02d:%02d",minute,second)
        return timeString
    }



}




