package br.com.ajeferson.architecturemvvm.di.modules

import android.content.Context
import br.com.ajeferson.architecturemvvm.di.annotations.ApplicationContext
import br.com.ajeferson.architecturemvvm.common.App
import dagger.Module
import dagger.Provides

/**
 * Created by ajeferson on 30/01/2018.
 */
@Module
class AppModule(private val app: App) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context = app.applicationContext

}