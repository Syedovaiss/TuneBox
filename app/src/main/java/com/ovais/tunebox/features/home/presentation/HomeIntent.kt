package com.ovais.tunebox.features.home.presentation

sealed interface HomeIntent {
    data object Play : HomeIntent
    data object Pause : HomeIntent
    data object Next : HomeIntent
    data object Previous : HomeIntent
}