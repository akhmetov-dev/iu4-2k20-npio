package ru.bmstu.iu4.sem07.interfaces


interface Factory<T> {
    fun generate(): T
}