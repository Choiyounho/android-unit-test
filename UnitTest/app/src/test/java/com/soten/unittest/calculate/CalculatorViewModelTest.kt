package com.soten.unittest.calculate

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CalculatorViewModelTest {

    private lateinit var calculatorViewModel: CalculatorViewModel
    private lateinit var calculations: Calculations

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule() // 이 클래스에서 아키텍쳐를 실행할 수 있게 해

    @Before
    fun setUp() {
        calculations = Mockito.mock(Calculations::class.java)
        Mockito.`when`(calculations.calculateArea(2.1)).thenReturn(13.8474)
        Mockito.`when`(calculations.calculateCircumference(1.0)).thenReturn(6.28)
        calculatorViewModel = CalculatorViewModel(calculations)
    }

    @Test
    fun calculateArea_livadata_test() {
        calculatorViewModel.calculateArea(2.1)
        val result = calculatorViewModel.areaValue.value

        Truth.assertThat(result).isEqualTo("13.8474")
    }

    @Test
    fun calculateCircumference_test() {
        calculatorViewModel.calculateCircumference(1.0)
        val result = calculatorViewModel.circumferenceValue.value

        Truth.assertThat(result).isEqualTo("6.28")
    }
}