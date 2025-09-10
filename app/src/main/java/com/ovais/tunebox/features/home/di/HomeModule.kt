package com.ovais.tunebox.features.home.di

import com.ovais.tunebox.features.home.data.HomeRepository
import com.ovais.tunebox.features.home.domain.DefaultGetAudiosUseCase
import com.ovais.tunebox.features.home.domain.DefaultHomeRepository
import com.ovais.tunebox.features.home.domain.GetAudiosUseCase
import com.ovais.tunebox.features.home.presentation.AudioMapper
import com.ovais.tunebox.features.home.presentation.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module


val homeViewModelModule = module {
    viewModel {
        HomeViewModel(
            getAudiosUseCase = get()
        )
    }
}

val homeFactoryModule = module {

    factory {
        DefaultHomeRepository(
            audioProvider = get()
        )
    } bind HomeRepository::class

    factory {
        AudioMapper(
            randomStringProvider = get()
        )
    }

    factory {
        DefaultGetAudiosUseCase(
            repository = get(),
            audioMapper = get()
        )
    } bind GetAudiosUseCase::class
}