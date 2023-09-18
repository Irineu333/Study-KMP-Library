package com.neo.base64

object JsBase64Encoder : Base64Encoder {
    override fun encode(src: ByteArray): ByteArray {
        val binString = src.decodeToString()
        return Base64.encode(binString).encodeToByteArray()
    }
}