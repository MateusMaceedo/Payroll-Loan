package br.com.solicita.aprovacao.parcela.core.utils

import java.net.NetworkInterface
import java.security.SecureRandom
import java.time.Instant

object SnowflakeID {
    private const val UNUSED_BITS = 1
    private const val EPOCH_BITS = 41
    private const val NODE_ID_BITS = 10
    private const val SEQUENCE_BITS = 12

    private const val maxNodeId = (1L shl NODE_ID_BITS) - 1
    private const val maxSequence = (1L shl SEQUENCE_BITS) - 1

    private const val DEFAULT_CUSTOM_EPOCH = 1420070400000L

    private val nodeId: Long = createNodeId()

    private const val customEpoch: Long = DEFAULT_CUSTOM_EPOCH

    @Volatile
    private var lastTimestamp = -1L

    @Volatile
    private var sequence = 0L

    @Synchronized
    fun nextId(): Long {
        var currentTimestamp = timestamp()
        check(currentTimestamp >= lastTimestamp) { "Invalid System Clock!" }
        if (currentTimestamp == lastTimestamp) {
            sequence = sequence + 1 and maxSequence
            if (sequence == 0L) {
                currentTimestamp = waitNextMillis(currentTimestamp)
            }
        } else {
            sequence = 0
        }
        lastTimestamp = currentTimestamp
        return (
                currentTimestamp shl NODE_ID_BITS + SEQUENCE_BITS
                        or (nodeId shl SEQUENCE_BITS)
                        or sequence
                )
    }

    fun parse(id: Long): LongArray {
        val maskNodeId = (1L shl NODE_ID_BITS) - 1 shl SEQUENCE_BITS
        val maskSequence = (1L shl SEQUENCE_BITS) - 1
        val timestamp = id shr NODE_ID_BITS + SEQUENCE_BITS + customEpoch.toInt()
        val nodeId = id and maskNodeId shr SEQUENCE_BITS
        val sequence = id and maskSequence
        return longArrayOf(timestamp, nodeId, sequence)
    }

    override fun toString(): String {
        return """
            Snowflake Settings [
                EPOCH_BITS='$EPOCH_BITS', 
                NODE_ID_BITS='$NODE_ID_BITS', 
                SEQUENCE_BITS='$SEQUENCE_BITS', 
                CUSTOM_EPOCH='$customEpoch',
                NodeId='$nodeId'
            ]
        """.trimIndent()
    }

    private fun timestamp(): Long {
        return Instant.now().toEpochMilli() - customEpoch
    }

    private fun waitNextMillis(timestamp: Long): Long {
        var currentTimestamp = timestamp
        while (currentTimestamp == lastTimestamp) {
            currentTimestamp = timestamp()
        }
        return currentTimestamp
    }


    private fun createNodeId(): Long {
        val nodeId = try {
            val sb = StringBuilder()
            val networkInterfaces = NetworkInterface.getNetworkInterfaces()
            while (networkInterfaces.hasMoreElements()) {
                val networkInterface = networkInterfaces.nextElement()
                for (macPort in networkInterface.hardwareAddress) {
                    sb.append(String.format("%02X", macPort))
                }
            }
            sb.toString().hashCode().toLong()
        } catch (ex: Exception) {
            SecureRandom().nextLong()
        }
        return nodeId and maxNodeId
    }
}