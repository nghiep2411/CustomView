package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.AdapterView
import android.widget.Toast


class SpinnerActivity : AppCompatActivity() {

    lateinit var spinner : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        spinner =  findViewById(R.id.spinner_language)
        val language = arrayOf("JAVA","KOTLIN","JAVASCRIPT","C++","DART","PYTHON","SQL")
        val arrayAdapter  = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,language)
        spinner.adapter=arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@SpinnerActivity,spinner.selectedItem.toString(),Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

    }
}