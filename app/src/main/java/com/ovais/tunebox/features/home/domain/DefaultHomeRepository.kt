package com.ovais.tunebox.features.home.domain

import com.ovais.tunebox.audio.AudioProvider
import com.ovais.tunebox.audio.AudioResources
import com.ovais.tunebox.features.home.data.HomeRepository

class DefaultHomeRepository(
    private val audioProvider: AudioProvider
) : HomeRepository {
    override fun getAudioResources(): List<AudioResources> {
        return audioProvider.get()
    }
}