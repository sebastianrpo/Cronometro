package com.sebastianrpo.cronometro.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sebastianrpo.cronometro.databinding.ActivitySplashBinding
import com.sebastianrpo.cronometro.ui.cronometro.CronometroActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {
    private lateinit var splashBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val view = splashBinding.root
        setContentView(view)

        val timer = Timer()
        timer.schedule(timerTask {
            val intent = Intent(this@SplashActivity, CronometroActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
        splashBinding.logoImageView.setOnClickListener{
            val intent = Intent(this, CronometroActivity::class.java)
            startActivity(intent)
        }
        Log.d("onCreate","OK")
    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart","OK")
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume","OK")
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause","OK")
    }

    override fun onStop() {
        super.onStop()
        Log.d("OnStop","OK")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart","OK")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy","OK")
    }
}