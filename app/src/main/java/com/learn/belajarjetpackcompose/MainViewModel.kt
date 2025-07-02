package com.learn.belajarjetpackcompose

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var number = 0
    fun incCount() {
        number++
    }
}