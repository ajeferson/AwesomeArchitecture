package br.com.ajeferson.architecturemvvm.di.module

import br.com.ajeferson.architecturemvvm.view.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by ajeferson on 31/01/2018.
 */
@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity

}