package br.com.ajeferson.architecturemvvm.di.component

import android.content.Context
import br.com.ajeferson.architecturemvvm.common.App
import br.com.ajeferson.architecturemvvm.common.NetManager
import br.com.ajeferson.architecturemvvm.di.annotation.ApplicationContext
import br.com.ajeferson.architecturemvvm.di.module.AppModule
import br.com.ajeferson.architecturemvvm.service.datasource.remote.GitRepoRemoteDataSource
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ajeferson on 30/01/2018.
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(app: App)
    fun inject(dataSource: GitRepoRemoteDataSource)

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