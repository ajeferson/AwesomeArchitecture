package br.com.ajeferson.architecturemvvm.service.repository

import br.com.ajeferson.architecturemvvm.service.datasource.local.UserLocalDataSource
import br.com.ajeferson.architecturemvvm.service.datasource.remote.UserRemoteDataSource
import br.com.ajeferson.architecturemvvm.common.NetManager
import br.com.ajeferson.architecturemvvm.service.model.User
import io.reactivex.Observable
import javax.inject.Inject

/**
 * MODEL
 * Should prepare data for the VIEW_MODEL
 * Should fetch data and cache in memory
 * It is not a data class (i.e. Car, Person, etc)
 * It is usually an implementation of the User Pattern
 * Abstracts the DataSource
 * Holds the entire business logic
 * Make caching
 */
class UserRepository @Inject constructor() {

    @Inject
    lateinit var localDataSource: UserLocalDataSource

    @Inject
    lateinit var remoteDataSource: UserRemoteDataSource

    @Inject
    lateinit var netManager: NetManager

    fun getUsers(): Observable<List<User>> {
        netManager.isConnectedToInternet?.let {
            if(it) {
                return remoteDataSource.getUsers()
                        .doOnNext {
                            localDataSource.saveUsers(it)
                        }
            }
        }
        return localDataSource.getUsers()
    }

}