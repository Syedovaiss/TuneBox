package com.ovais.tunebox.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ovais.tunebox.features.home.data.AudioFile
import com.ovais.tunebox.features.home.domain.GetAudiosUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getAudiosUseCase: GetAudiosUseCase
) : ViewModel() {

    private val _uiState by lazy {
        MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    }
    val uiState: StateFlow<HomeUiState>
        get() = _uiState.asStateFlow()

    private val _audioFile by lazy { MutableStateFlow(getAudiosUseCase()) }
    private val audioFile: StateFlow<AudioFile?>
        get() = _audioFile.asStateFlow()

    init {
        fetchAudios()
    }

    private fun fetchAudios() {
        viewModelScope.launch {
            _uiState.update {
                HomeUiState.Loaded(
                    audio = audioFile.value,
                    isPlaying = false
                )
            }
        }
    }

    fun onEvent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.Play -> startPlaying()
            is HomeIntent.Pause -> stopPlaying()
            is HomeIntent.Next -> playNextTrack()
            is HomeIntent.Previous -> playPreviousTrack()
        }
    }

    private fun playNextTrack() {
        _uiState.update {
            (uiState.value as HomeUiState.Loaded).copy(
                audio = audioFile.value?.next
            )
        }
    }

    private fun playPreviousTrack() {
        _uiState.update {
            (uiState.value as HomeUiState.Loaded).copy(
                audio = audioFile.value?.previous
            )
        }
    }

    private fun stopPlaying() {
        _uiState.update {
            (uiState.value as HomeUiState.Loaded).copy(
                isPlaying = false
            )
        }
    }

    private fun startPlaying() {
        _uiState.update {
            (uiState.value as HomeUiState.Loaded).copy(
                isPlaying = true
            )
        }
    }
}