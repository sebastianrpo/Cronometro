package com.sebastianrpo.cronometro.ui.cronometro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sebastianrpo.cronometro.databinding.ActivityCronometroBinding

class CronometroActivity : AppCompatActivity() {
    private lateinit var cronometroBinding: ActivityCronometroBinding
    private lateinit var cronometroViewModel: CronometroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cronometroBinding = ActivityCronometroBinding.inflate(layoutInflater)
        val view = cronometroBinding.root
        setContentView(view)

        cronometroViewModel = ViewModelProvider(this)[CronometroViewModel::class.java]

        cronometroViewModel.timer.observe(this) {
            cronometroBinding.cronometroTextView.text = it
        }

        cronometroBinding.startFloatingButton.setOnClickListener {
            cronometroViewModel.startTimer()
        }

        cronometroBinding.pauseFloatingButton.setOnClickListener {
            cronometroViewModel.pauseTimer()
        }

        cronometroBinding.stopFloatingButton.setOnClickListener {
            cronometroViewModel.stopTimer()
        }
    }
}

