package com.neo.base64

actual object Base64Factory {
    actual fun createEncoder(): Base64Encoder = JsBase64Encoder
}