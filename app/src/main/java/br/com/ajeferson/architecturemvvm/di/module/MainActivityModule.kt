package br.com.ajeferson.architecturemvvm.di.module

import br.com.ajeferson.architecturemvvm.service.common.MainService
import dagger.Module
import dagger.Provides

/**
 * Created by ajeferson on 30/01/2018.
 */
@Module
class MainActivityModule {

    @Provides
    fun providesMainModule() = MainService()

}