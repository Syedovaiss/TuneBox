package com.ovais.tunebox.utils

fun interface Provider<T> {
    fun get(): T
}