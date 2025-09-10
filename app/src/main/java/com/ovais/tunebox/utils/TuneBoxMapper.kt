package com.ovais.tunebox.utils

fun interface TuneBoxMapper<Param, ReturnType> {
    fun map(from: Param): ReturnType
}
