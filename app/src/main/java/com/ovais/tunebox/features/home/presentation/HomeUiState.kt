package com.ovais.tunebox.features.home.presentation

import com.ovais.tunebox.features.home.data.AudioFile

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Loaded(
        val audio: AudioFile?,
        val isPlaying: Boolean
    ) : HomeUiState
}