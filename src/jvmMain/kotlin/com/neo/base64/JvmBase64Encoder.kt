package com.neo.base64

import java.util.Base64

object JvmBase64Encoder : Base64Encoder {
    override fun encode(src: ByteArray): ByteArray = Base64.getEncoder().encode(src)

    // more efficient implementation in jvm
    override fun encodeToString(src: ByteArray): String = Base64.getEncoder().encodeToString(src)
}