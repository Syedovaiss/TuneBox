package com.ovais.tunebox.utils

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum

fun interface RandomStringProvider {
    fun get(count: Int): String
}

class DefaultRandomStringProvider : RandomStringProvider {
    override fun get(count: Int): String {
        return LoremIpsum(count).values.joinToString()
    }
}