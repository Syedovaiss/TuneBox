package com.ovais.tunebox.features.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber


@Composable
fun HomeScreen(
    padding: PaddingValues = PaddingValues(),
    viewModel: HomeViewModel = koinViewModel(),
    snackbarHostState: SnackbarHostState
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        when (uiState) {
            is HomeUiState.Loading -> HomeScreenLoadingView()

            is HomeUiState.Loaded -> {
                val state = (uiState as HomeUiState.Loaded)
                HomeScreenLoadedView(
                    imageUrl = state.audio?.thumbnail,
                    title = state.audio?.title,
                    recitedBy = state.audio?.recitedBy,
                    isPlaying = state.isPlaying,
                    file = state.audio?.file,
                    onAction = { action ->
                        when (action) {
                            is HomeAction.Next -> viewModel.onEvent(HomeIntent.Next)
                            is HomeAction.Previous -> viewModel.onEvent(HomeIntent.Previous)
                            is HomeAction.BackPress -> {
                                Timber.i("Back Press!")
                            }

                            is HomeAction.FavouriteList -> {
                                Timber.i("Navigate to favourite list!")
                            }

                            is HomeAction.CenterIcon -> {
                                val intent =
                                    if (state.isPlaying) HomeIntent.Pause else HomeIntent.Play
                                viewModel.onEvent(intent)
                            }
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        snackbarHostState = SnackbarHostState()
    )
}