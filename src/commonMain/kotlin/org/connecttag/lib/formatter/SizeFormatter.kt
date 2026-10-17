package org.connecttag.lib.formatter

import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.roundToLong

public object SizeFormatter {
    public fun formatFileSize(size: Long, fractionDigits: Int = 2): String {
        if (size <= 0) return "0 B"
        val units = arrayOf("B", "KB", "MB", "GB", "TB")
        val digitGroups = (log10(size.toDouble()) / log10(1024.0)).toInt().coerceIn(units.indices)
        val value = size / 1024.0.pow(digitGroups.toDouble())
        return "${formatDecimal(value, fractionDigits.coerceIn(0, 4))} ${units[digitGroups]}"
    }

    public fun formatCompactFileSize(size: Long): String {
        if (size <= 0) return "0 B"
        val units = arrayOf("B", "KB", "MB", "GB", "TB")
        val digitGroups = (log10(size.toDouble()) / log10(1024.0)).toInt().coerceIn(units.indices)
        val value = size / 1024.0.pow(digitGroups.toDouble())
        val fractionDigits = if (value >= 10 || digitGroups == 0) 0 else 1
        return "${formatDecimal(value, fractionDigits)} ${units[digitGroups]}"
    }

    /**
     * Formats network speed or throughput in bytes per second (e.g., "1.2 MB/s", "500 KB/s", "0 B/s").
     */
    public fun formatSpeed(bytesPerSec: Long, fractionDigits: Int = 1): String {
        if (bytesPerSec <= 0L) return "0 B/s"
        val kbs = bytesPerSec / 1024.0
        return when {
            kbs >= 1024.0 * 1024.0 -> "${formatDecimal(kbs / (1024.0 * 1024.0), fractionDigits)} GB/s"
            kbs >= 1024.0 -> "${formatDecimal(kbs / 1024.0, fractionDigits)} MB/s"
            kbs >= 1.0 -> "${formatDecimal(kbs, 0)} KB/s"
            else -> "$bytesPerSec B/s"
        }
    }

    /**
     * Formats network bitrate in bits per second (e.g., "10.5 Mbps", "512 Kbps", "1.2 Gbps").
     */
    public fun formatBitrate(bitsPerSec: Long, fractionDigits: Int = 1): String {
        if (bitsPerSec <= 0L) return "0 bps"
        val units = arrayOf("bps", "Kbps", "Mbps", "Gbps", "Tbps")
        val digitGroups = (log10(bitsPerSec.toDouble()) / log10(1000.0)).toInt().coerceIn(units.indices)
        val value = bitsPerSec / 1000.0.pow(digitGroups.toDouble())
        return "${formatDecimal(value, fractionDigits)} ${units[digitGroups]}"
    }

    /**
     * Formats packet counts into compact representation (e.g., "1.2K pkts", "500 pkts").
     */
    public fun formatPackets(count: Long): String {
        return when {
            count >= 1_000_000 -> "${formatDecimal(count / 1_000_000.0, 1)}M pkts"
            count >= 1_000 -> "${formatDecimal(count / 1_000.0, 1)}K pkts"
            else -> "$count pkts"
        }
    }

    private fun formatDecimal(value: Double, fractionDigits: Int): String {
        val divisor = 10.0.pow(fractionDigits).roundToLong()
        val scaled = (value * divisor).roundToLong()
        val whole = scaled / divisor
        if (fractionDigits == 0) {
            return whole.toString()
        }

        val fraction = (scaled % divisor).toString().padStart(fractionDigits, '0')
        return "$whole.$fraction"
    }
}
