package com.ubalia.fragment.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomViewModel: ViewModel() {
    private val mutableRandomData = MutableLiveData<Int>()
    val randomData: LiveData<Int> get() = mutableRandomData

    fun setRandomData(randomNumber: Int) {
        mutableRandomData.value = randomNumber
    }
}