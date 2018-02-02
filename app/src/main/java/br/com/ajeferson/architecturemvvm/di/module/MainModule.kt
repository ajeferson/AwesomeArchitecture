package br.com.ajeferson.architecturemvvm.di.module

import br.com.ajeferson.architecturemvvm.service.datasource.remote.UserRemoteDataSource
import br.com.ajeferson.architecturemvvm.service.repository.UserRepository
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
    fun provideMainViewModelFactory(userRepository: UserRepository) = MainViewModelFactory(userRepository)

    @Provides
    fun provideGitRepoRemoteDataSourceApi(retrofit: Retrofit): UserRemoteDataSource.Api = retrofit.create(UserRemoteDataSource.Api::class.java)

}