package br.com.ajeferson.architecturemvvm.common

import android.app.Application
import br.com.ajeferson.architecturemvvm.di.component.AppComponent
import br.com.ajeferson.architecturemvvm.di.component.DaggerAppComponent
import br.com.ajeferson.architecturemvvm.di.module.AppModule
import javax.inject.Inject

/**
 * Created by ajeferson on 30/01/2018.
 */
class App: Application() {

    lateinit var appComponent: AppComponent

    @Inject
    lateinit var netManager: NetManager

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
        appComponent.inject(this)
        println("Injected")
    }

}