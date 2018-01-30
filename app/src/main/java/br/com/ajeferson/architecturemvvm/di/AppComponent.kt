package br.com.ajeferson.architecturemvvm.di

import br.com.ajeferson.architecturemvvm.common.App
import br.com.ajeferson.architecturemvvm.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by ajeferson on 30/01/2018.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    BuildersModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent

    }

    fun inject(app: App)

}