package com.soten.unittest.calculate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CalculatorViewModelFactory(
    private val calculations: Calculations
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CalculatorViewModel(calculations) as T
    }

}