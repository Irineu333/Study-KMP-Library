package com.neo.base64

expect object Base64Factory {
    fun createEncoder(): Base64Encoder
}