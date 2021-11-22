package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView


class ProgressBarActivity : AppCompatActivity() {

    lateinit var progressBar1 : ProgressBar
    lateinit var progressBar2: ProgressBar
    lateinit var buttonStart1 : Button
    lateinit var buttonStart2 : Button
    lateinit var textViewInfo1:TextView
    lateinit var textViewInfo2:TextView
    private val handler: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)
        progressBar1 = findViewById(R.id.progressBar1)
        progressBar2= findViewById(R.id.progressBar2)
        buttonStart1 = findViewById(R.id.button1)
        buttonStart2 = findViewById(R.id.button2)
        textViewInfo1 = findViewById(R.id.textView1)
        textViewInfo2 = findViewById(R.id.textView2)

        buttonStart1.setOnClickListener {
            doStartProgressBar1()
        }

        buttonStart2.setOnClickListener {
            doStartProgressBar2()
        }

    }

    private fun doStartProgressBar1() {
        val MAX = 110
        this.progressBar1.setMax(MAX)
        val thread = Thread {
            handler.post(Runnable { buttonStart1.setEnabled(false) })
            for (i in 0 until MAX) {
                val progress = i + 1
                // Do something (Download, Upload, Update database,..)
                SystemClock.sleep(20) // Sleep 20 milliseconds.

                // Update interface.
                handler.post(Runnable {
                    progressBar1.setProgress(progress)
                    val percent = progress * 100 / MAX
                    textViewInfo1.setText("Percent: $percent %")
                    if (progress == MAX) {
                        textViewInfo1.setText("Completed!")
                        buttonStart1.setEnabled(true)
                    }
                })
            }
        }
        thread.start()
    }

    private fun doStartProgressBar2() {
        this.progressBar2.setIndeterminate(true)
        val thread = Thread { // Update interface
            handler.post(Runnable {
                textViewInfo2.setText("Working...")
                buttonStart2.setEnabled(false)
            })
            // Do something ... (Update database,..)
            SystemClock.sleep(5000) // Sleep 5 seconds.
            progressBar2.setIndeterminate(false)
            progressBar2.setMax(1)
            progressBar2.setProgress(1)

            // Update interface
            handler.post(Runnable {
                textViewInfo2.setText("Completed!")
                buttonStart2.setEnabled(true)
            })
        }
        thread.start()
    }
}