package br.com.ajeferson.architecturemvvm.di.module

import br.com.ajeferson.architecturemvvm.service.datasource.remote.GitRepoRemoteDataSource
import br.com.ajeferson.architecturemvvm.service.repository.GitRepoRepository
import br.com.ajeferson.architecturemvvm.viewmodel.factory.MainViewModelFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by ajeferson on 31/01/2018.
 */
@Module
class MainModule {

    @Provides
    fun provideMainViewModelFactory(gitRepoRepository: GitRepoRepository) = MainViewModelFactory(gitRepoRepository)

    @Provides
    fun provideGitRepoRemoteDataSourceApi(retrofit: Retrofit): GitRepoRemoteDataSource.Api = retrofit.create(GitRepoRemoteDataSource.Api::class.java)

}