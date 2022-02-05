package com.soten.unittest.calculate

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun calculate_circumference_test() {
        val result = calculator.calculateCircumference(2.1)
        Truth.assertThat(result).isEqualTo(13.188)
    }

}