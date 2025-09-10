package com.ovais.tunebox.utils

fun interface UseCase<ReturnType> {
    operator fun invoke(): ReturnType
}