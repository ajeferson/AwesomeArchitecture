package br.com.ajeferson.architecturemvvm.di.component

import br.com.ajeferson.architecturemvvm.common.App
import br.com.ajeferson.architecturemvvm.di.module.AppModule
import br.com.ajeferson.architecturemvvm.di.module.BuildersModule
import br.com.ajeferson.architecturemvvm.di.module.DatabaseModule
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
    DatabaseModule::class,
    BuildersModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent

    }

    fun inject(app: App)

    /**
     * These methods represent the "roots" of the dependency graph
     * It's like it goes over resolving dependencies starting by these types
     * If there aren't any methods whose return type is something provided
     * by the one of the modules, the set module methods will appear as deprecated
     * */

}