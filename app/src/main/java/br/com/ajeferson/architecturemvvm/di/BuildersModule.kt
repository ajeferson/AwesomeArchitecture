package br.com.ajeferson.architecturemvvm.di

import br.com.ajeferson.architecturemvvm.di.module.MainActivityModule
import br.com.ajeferson.architecturemvvm.view.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by ajeferson on 30/01/2018.
 */
@Module
abstract class BuildersModule {

    // Binds both AppModule and MainActivityModule
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindLobbyActivity(): MainActivity

    // Add bindings for other sub-components here

}