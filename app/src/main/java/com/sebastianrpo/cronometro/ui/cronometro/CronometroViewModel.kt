package com.sebastianrpo.cronometro.ui.cronometro

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CronometroViewModel : ViewModel() {
    private lateinit var countDownTimer: CountDownTimer
    private val _timer = MutableLiveData<String>()
    val timer: LiveData<String> = _timer
    private var isRunning = false
    private var elapsedTime = 0L

    init {
        _timer.value = "00:00:00"
    }

    fun startTimer() {
        if (!isRunning) {
            countDownTimer = object : CountDownTimer(Long.MAX_VALUE, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    elapsedTime += 1000
                    val hours = (elapsedTime / 3600000).toInt()
                    val minutes = ((elapsedTime / 60000) % 60).toInt()
                    val seconds = ((elapsedTime / 1000) % 60).toInt()
                    _timer.value = String.format("%02d:%02d:%02d", hours, minutes, seconds)
                }

                override fun onFinish() {}
            }
            countDownTimer.start()
            isRunning = true
        }
    }

    fun pauseTimer() {
        if (isRunning) {
            countDownTimer.cancel()
            isRunning = false
        }
    }

    fun stopTimer() {
        if (isRunning) {
            countDownTimer.cancel()
            isRunning = false
        }
        elapsedTime = 0L
        _timer.value = "00:00:00"
    }
}
