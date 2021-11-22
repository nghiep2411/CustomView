package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast


class CheckBoxActivity : AppCompatActivity() {

    lateinit var checkAll: CheckBox
    lateinit var checkAndroid: CheckBox
    lateinit var checkPHP: CheckBox
    lateinit var checkJava: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)
        checkAll = findViewById(R.id.checkBox1)
        checkAndroid = findViewById(R.id.checkBox2)
        checkPHP = findViewById(R.id.checkBox3)
        checkJava = findViewById(R.id.checkBox4)



        checkAll.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                checkAll(true)
                Toast.makeText(this, "Checked All", Toast.LENGTH_LONG).show();
            }else{
                checkAll(false)
                Toast.makeText(this, "UnChecked All", Toast.LENGTH_LONG).show();
            }

        }


    }

    fun checkAll(isChecked : Boolean){
        checkAndroid.isChecked =isChecked
        checkPHP.isChecked =isChecked
        checkJava.isChecked =isChecked
    }

//    fun showToast(){
//        if(checkAndroid.isChecked){
//            Toast.makeText(this, "Checked Android", Toast.LENGTH_LONG).show();
//        }
//        if(checkPHP.isChecked){
//            Toast.makeText(this, "Checked PHP", Toast.LENGTH_LONG).show();
//        }
//        if(checkJava.isChecked){
//            Toast.makeText(this, "Checked JAVA", Toast.LENGTH_LONG).show();
//        }
//    }

}