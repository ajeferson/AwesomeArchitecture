package br.com.ajeferson.architecturemvvm.di.module

import android.content.Context
import br.com.ajeferson.architecturemvvm.common.App
import br.com.ajeferson.architecturemvvm.service.common.CommonService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ajeferson on 30/01/2018.
 */
@Module
class AppModule {

    @Provides
    fun provideContext(application: App): Context = application.applicationContext

    // Application-wide dependency
    @Singleton
    @Provides
    fun provideCommonHelloService(): CommonService = CommonService()

}