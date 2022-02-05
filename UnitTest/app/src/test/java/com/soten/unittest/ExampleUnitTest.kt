package com.soten.unittest

import com.google.common.truth.Truth
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun hello_test() {
        val result = "fail"

        Truth.assertThat(result).isEqualTo("fail")
    }
}