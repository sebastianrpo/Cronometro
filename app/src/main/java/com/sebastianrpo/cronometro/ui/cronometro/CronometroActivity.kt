package com.sebastianrpo.cronometro.ui.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ProgressBar
import com.sebastianrpo.cronometro.databinding.ActivityCronometroBinding

class CronometroActivity : AppCompatActivity() {
    private lateinit var cronometroBinding: ActivityCronometroBinding
    private lateinit var timer: CountDownTimer
    private var isRunning = false
    private var elapsedTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cronometroBinding = ActivityCronometroBinding.inflate(layoutInflater)
        val view = cronometroBinding.root
        setContentView(view)

        val btnStart = cronometroBinding.startFloatingButton
        val btnStop = cronometroBinding.stopFloatingButton
        val tvTimer = cronometroBinding.cronometroTextView
        val btnPause = cronometroBinding.pauseFloatingButton

        //Botón inicio
        btnStart.setOnClickListener {
            if (!isRunning) {
                timer = object : CountDownTimer(Long.MAX_VALUE, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        elapsedTime += 1000
                        val hours = (elapsedTime / 3600000).toInt()
                        val minutes = ((elapsedTime / 60000) % 60).toInt()
                        val seconds = ((elapsedTime / 1000) % 60).toInt()
                        tvTimer.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)
                    }

                    override fun onFinish() {}
                }
                timer.start()
                isRunning = true
            }
        }

        btnPause.setOnClickListener {
            if (isRunning) {
                timer.cancel()
                isRunning = false
            }
        }

        btnStop.setOnClickListener {
            if (isRunning) {
                timer.cancel()
                isRunning = false
            }
            elapsedTime = 0L
            tvTimer.text = "00:00:00"
        }
    }
}


