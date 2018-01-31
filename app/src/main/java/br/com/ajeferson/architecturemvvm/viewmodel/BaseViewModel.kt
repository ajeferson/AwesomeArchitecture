package br.com.ajeferson.architecturemvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import br.com.ajeferson.architecturemvvm.common.App
import br.com.ajeferson.architecturemvvm.common.NetManager
import br.com.ajeferson.architecturemvvm.di.components.DaggerViewModelComponent
import br.com.ajeferson.architecturemvvm.di.modules.ViewModelModule
import javax.inject.Inject

/**
 * Created by ajeferson on 31/01/2018.
 */
open class BaseViewModel(application: Application): AndroidViewModel(application) {


    @Inject
    lateinit var netManager: NetManager

    init {
        (application as? App)?.let {
            DaggerViewModelComponent
                    .builder()
                    .viewModelModule(ViewModelModule(this))
                    .appComponent(it.appComponent)
                    .build()
                    .inject(this)
            println("Injected")
        }
    }


}