package com.lwp.java.third_party.k8s

import java.io.OutputStream
import java.nio.charset.StandardCharsets

class ContainerLogWatchOutputStream(val saveLogAction: (String?) -> Unit) : OutputStream() {
    private var count: Int = 0
    private var maxLen: Int = 8192
    private var buf: ByteArray = ByteArray(maxLen)
    private val sep = '\n'.toByte().toInt()


    override fun write(b: Int) {
        buf[count++] = b.toByte()

        if (count >= maxLen - 1 || b == sep) {
            val saveLog = String(buf.copyOf(count + 1), StandardCharsets.UTF_8)
            saveLogAction(saveLog)
            reset()
        }
    }

    private fun reset() {
        for (i in 0 until count) {
            buf[i] = 0
        }
        count = 0
    }
}
