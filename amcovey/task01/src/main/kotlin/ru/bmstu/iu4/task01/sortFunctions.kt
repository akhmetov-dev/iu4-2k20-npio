package ru.bmstu.iu4.task01

fun IntArray.printArray(){
    for ((index, value) in withIndex())
        println("[$index]: $value")
}

fun IntArray.bubbleSortIncrease(): IntArray{
    for (i in 0 until (size - 1)){
        for (j in 0 until (size - i - 1)){
            if (this[j] > this[j + 1]){
                this[j] = this[j + 1].also { this[j + 1] = this[j] }
            }
        }
    }
    return this
}

fun IntArray.quickSortDecrease(): IntArray{
    var startIndex = 0
    var endIndex = lastIndex
    makeSort(this, startIndex, endIndex)
    return this
}

fun makeSort(array: IntArray, startIndex: Int, endIndex: Int){
    if (startIndex >= endIndex)
        return
    var i = startIndex
    var j = endIndex
    var curr = i - (i - j) / 2
    while (i < j){
        while (i < curr && (array[i] >= array[curr])) {
            i++
        }
        while (j > curr && (array[curr] >= array[j])){
            j--
        }
        if (i < j){
            array[j] = array[i].also { array[i] = array[j] }
            if (i == curr)
                curr = j
            else if (j == curr)
                curr = i
        }
    }
    makeSort(array, startIndex, curr)
    makeSort(array, curr + 1, endIndex)
}