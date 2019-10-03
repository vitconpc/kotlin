package com.vitcon.study_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.vitcon.myapplication.R
import java.lang.Integer.parseInt

class StudyActivity : AppCompatActivity() {

    lateinit var text : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study)
    }
}
