package br.com.ajeferson.architecturemvvm.di.components

import br.com.ajeferson.architecturemvvm.common.NetManager
import br.com.ajeferson.architecturemvvm.di.annotations.PerViewModel
import br.com.ajeferson.architecturemvvm.di.modules.ViewModelModule
import br.com.ajeferson.architecturemvvm.viewmodel.BaseViewModel
import dagger.Component

/**
 * Created by ajeferson on 31/01/2018.
 */
@PerViewModel
@Component(dependencies = [AppComponent::class], modules = [ViewModelModule::class])
interface ViewModelComponent {

    fun inject(viewModel: BaseViewModel)

    fun netManager(): NetManager

}