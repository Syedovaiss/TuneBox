package com.ovais.tunebox.features.home.data

import com.ovais.tunebox.audio.AudioResources

fun interface HomeRepository {
    fun getAudioResources(): List<AudioResources>
}