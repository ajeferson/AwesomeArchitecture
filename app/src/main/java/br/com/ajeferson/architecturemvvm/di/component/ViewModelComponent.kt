package br.com.ajeferson.architecturemvvm.di.component

import br.com.ajeferson.architecturemvvm.common.NetManager
import br.com.ajeferson.architecturemvvm.di.annotation.PerViewModel
import br.com.ajeferson.architecturemvvm.di.module.ViewModelModule
import br.com.ajeferson.architecturemvvm.service.repository.GitRepoRepository
import br.com.ajeferson.architecturemvvm.viewmodel.MainViewModel
import dagger.Component

/**
 * Created by ajeferson on 31/01/2018.
 */
@PerViewModel
@Component(dependencies = [AppComponent::class], modules = [ViewModelModule::class])
interface ViewModelComponent {

    fun inject(viewModel: MainViewModel)

    fun netManager(): NetManager

    fun gitRepoRepository(): GitRepoRepository

}