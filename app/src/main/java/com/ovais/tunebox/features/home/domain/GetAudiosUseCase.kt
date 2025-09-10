package com.ovais.tunebox.features.home.domain

import com.ovais.tunebox.features.home.data.AudioFile
import com.ovais.tunebox.features.home.data.HomeRepository
import com.ovais.tunebox.features.home.presentation.AudioMapper
import com.ovais.tunebox.utils.UseCase

interface GetAudiosUseCase : UseCase<AudioFile?>

class DefaultGetAudiosUseCase(
    private val repository: HomeRepository,
    private val audioMapper: AudioMapper
) : GetAudiosUseCase {
    override fun invoke(): AudioFile? {
        val resources = repository.getAudioResources()
        return audioMapper.map(resources)
    }
}