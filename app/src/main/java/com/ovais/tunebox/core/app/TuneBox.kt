package com.ovais.tunebox.core.app

import android.app.Application
import com.ovais.tunebox.core.di.singletonModule
import com.ovais.tunebox.features.home.di.homeFactoryModule
import com.ovais.tunebox.features.home.di.homeViewModelModule
import com.ovais.tunebox.utils.DefaultTuneBoxLogger
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class TuneBox : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@TuneBox)
            modules(
                singletonModule,
                homeViewModelModule,
                homeFactoryModule
            )
        }
    }

    private fun initTimber() {
        Timber.plant(DefaultTuneBoxLogger())
    }
}