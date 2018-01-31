package br.com.ajeferson.architecturemvvm.di.components

import android.content.Context
import br.com.ajeferson.architecturemvvm.common.App
import br.com.ajeferson.architecturemvvm.common.NetManager
import br.com.ajeferson.architecturemvvm.di.annotations.ApplicationContext
import br.com.ajeferson.architecturemvvm.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ajeferson on 30/01/2018.
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(app: App)

    @ApplicationContext
    fun context(): Context

    fun netManager(): NetManager

    /**
     * These methods represent the "roots" of the dependency graph
     * It's like it goes over resolving dependencies starting by these types
     * If there aren't any methods whose return type is something provided
     * by the one of the modules, the set module methods will appear as deprecated
     * */

}