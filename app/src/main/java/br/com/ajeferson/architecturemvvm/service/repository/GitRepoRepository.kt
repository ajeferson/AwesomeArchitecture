package br.com.ajeferson.architecturemvvm.service.repository

import android.content.Context
import br.com.ajeferson.architecturemvvm.service.datasource.local.GitRepoLocalDataSource
import br.com.ajeferson.architecturemvvm.service.datasource.remote.GitRepoRemoteDataSource
import br.com.ajeferson.architecturemvvm.common.NetManager
import br.com.ajeferson.architecturemvvm.service.model.Repository
import io.reactivex.Observable
import javax.inject.Singleton

/**
 * MODEL
 * Should prepare data for the VIEW_MODEL
 * Should fetch data and cache in memory
 * It is not a data class (i.e. Car, Person, etc)
 * It is usually an implementation of the Repository Pattern
 * Abstracts the DataSource
 * Holds the entire business logic
 * Make caching
 */
class GitRepoRepository(context: Context) {

    private val localDataSource = GitRepoLocalDataSource()
    private val remoteDataSource = GitRepoRemoteDataSource()
    private val netManager = NetManager(context)

    fun getGitRepositories(): Observable<List<Repository>> {
        netManager.isConnectedToInternet?.let {
            if(it) {
                //TODO Save repositories to local data store
//                return remoteDataSource.getGitRepositories().doOnNext {
//                    localDataSource.saveRepositories(it)
//                }
                remoteDataSource.getGitRepositories().flatMap {
                    return@flatMap localDataSource.saveRepositories(it)
                            .toSingleDefault(it)
                            .toObservable()
                }
            }
        }
        return localDataSource.getGitRepositories()
    }

}