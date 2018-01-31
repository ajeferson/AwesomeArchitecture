package br.com.ajeferson.architecturemvvm.di.module

import br.com.ajeferson.architecturemvvm.service.repository.GitRepoRepository
import br.com.ajeferson.architecturemvvm.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by ajeferson on 31/01/2018.
 */
@Module
class MainModule {

    @Provides
    fun provideMainViewModelFactory(gitRepoRepository: GitRepoRepository) = MainViewModelFactory(gitRepoRepository)

}