package com.example.services

import android.Manifest
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0

            )
        }
        val button=findViewById<Button>(R.id.button)
        val button2=findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            Intent(applicationContext,RunningService::class.java).also {
                it.action=RunningService.Actions.START.toString()
                startService(it)
            }
        }
        button2.setOnClickListener {
            Intent(applicationContext,RunningService::class.java).also {
                it.action=RunningService.Actions.STOP.toString()
                startService(it)
            }
        }

    }
}