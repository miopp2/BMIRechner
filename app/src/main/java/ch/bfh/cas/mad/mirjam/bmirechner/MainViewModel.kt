package ch.bfh.cas.mad.mirjam.bmirechner

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    fun calculateBmi(heightInCm: Int, weightInKg: Int): Double {
        val heightM = (heightInCm / 100.0)
        return weightInKg / ( heightM * heightM)
    }
}