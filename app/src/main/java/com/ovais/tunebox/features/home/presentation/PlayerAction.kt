package com.ovais.tunebox.features.home.presentation

sealed interface HomeAction {
    data object BackPress : HomeAction
    data object CenterIcon : HomeAction
    data object Previous : HomeAction
    data object Next : HomeAction
    data object FavouriteList : HomeAction
}