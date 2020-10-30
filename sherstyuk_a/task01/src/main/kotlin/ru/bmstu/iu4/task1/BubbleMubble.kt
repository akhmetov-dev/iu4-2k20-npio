package ru.bmstu.iu4.task1

import ru.inforion.lab403.common.logging.FINEST
import ru.inforion.lab403.common.logging.logger


object BubbleMubble {
    val log = logger(FINEST)

    @JvmStatic
    fun main(args: Array<String>) {
        val data = intArrayOf(6,2,0,8,3,5,7)
        log.config { "Input data: ${data.toList()}" }
        myBubbleSort(data)
        log.fine { "Sorted Data: ${data.toList()}" }
    }

    fun myBubbleSort(data: IntArray) {
        for (passed in 0 until (data.size - 1)) {
            for (currentPosition in 0 until (data.size - passed - 1)) {
                if (data[currentPosition] > data[currentPosition + 1]) {
                    val tmp = data[currentPosition]
                    data[currentPosition] = data[currentPosition + 1]
                    data[currentPosition + 1] = tmp
                }
            }
        }
        log.info { "Data sorted!" }
    }
}