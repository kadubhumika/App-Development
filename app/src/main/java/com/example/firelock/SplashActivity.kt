package com.example.firelock

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.firelock.R

class SplashActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen) // Ensure you have activity_splash.xml

        // Delay for 3 seconds before switching to SignInActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish() // Close splash screen so user can't go back to it
        }, 3000) // 3000ms = 3 seconds
    }

}