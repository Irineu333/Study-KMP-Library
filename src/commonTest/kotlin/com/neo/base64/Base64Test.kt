package com.neo.base64

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Base64Test {

    private lateinit var encoder: Base64Encoder

    @BeforeTest
    fun setup() {
        encoder = Base64Factory.createEncoder()
    }

    @Test
    fun testEncodeToString() {
        checkEncodeToString("Kotlin is awesome", "S290bGluIGlzIGF3ZXNvbWU=")
    }

    @Test
    fun testPaddedStrings() {
        checkEncodeToString("", "")
        checkEncodeToString("1", "MQ==")
        checkEncodeToString("22", "MjI=")
        checkEncodeToString("333", "MzMz")
        checkEncodeToString("4444", "NDQ0NA==")
    }

    private fun checkEncodeToString(input: String, expectedOutput: String) {

        val output = encoder.encodeToString(input.asciiToByteArray())

        assertEquals(
            expectedOutput,
            output
        )
    }

    private fun String.asciiToByteArray() = ByteArray(length) {
        get(it).code.toByte()
    }
}

// run with ./gradle check