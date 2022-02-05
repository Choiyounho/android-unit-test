package com.soten.unittest.calculate

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel(
    private val calculations: Calculations
) : ViewModel() {

    val radius = MutableLiveData<String>()

    private val area = MutableLiveData<String>()
    val areaValue: LiveData<String> get() = area

    private val circumference = MutableLiveData<String>()
    val circumferenceValue: LiveData<String> get() = circumference

    fun calculate() {
        try {
            val radiusDoubleValue = radius.value?.toDouble()

            if (radiusDoubleValue != null) {
                calculateArea(radiusDoubleValue)
                calculateCircumference(radiusDoubleValue)
            } else {
                area.value = "null 입니다"
                circumference.value ="null 입니다"
            }
        } catch (e: Exception) {
            Log.i(TAG, e.message!!)
            area.value = "오류 입니다"
            circumference.value = "오류 입니다"
        }
    }

    fun calculateArea(radius: Double) {
        val calculatedArea = calculations.calculateArea(radius)
        area.value = calculatedArea.toString()
    }

    fun calculateCircumference(radius: Double) {
        val calculatedCircumference = calculations.calculateCircumference(radius)
        circumference.value = calculatedCircumference.toString()
    }

    companion object {
        private const val TAG = "CalculatorViewModel"
    }

}