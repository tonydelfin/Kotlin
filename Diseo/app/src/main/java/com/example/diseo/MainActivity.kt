package com.example.diseo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //setContentView(R.layout.linear_layout)
        //setContentView(R.layout.frame_layout)
        setContentView(R.layout.constraint_layout)
    }
}