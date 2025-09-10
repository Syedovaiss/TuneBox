package com.ovais.tunebox.core.di

import com.ovais.tunebox.audio.AudioProvider
import com.ovais.tunebox.utils.DefaultRandomStringProvider
import com.ovais.tunebox.utils.RandomStringProvider
import org.koin.dsl.bind
import org.koin.dsl.module


val singletonModule = module {
    single { AudioProvider() }
    single { DefaultRandomStringProvider() } bind RandomStringProvider::class
}