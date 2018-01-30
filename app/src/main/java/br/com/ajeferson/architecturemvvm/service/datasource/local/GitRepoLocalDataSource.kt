package br.com.ajeferson.architecturemvvm.service.datasource.local

import br.com.ajeferson.architecturemvvm.service.model.Repository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

/**
 * Created by ajeferson on 27/01/2018.
 */
class GitRepoLocalDataSource {

    fun getGitRepositories(): Observable<List<Repository>> {
        val repositories = listOf(
                Repository("First Local", "Owner 1", 100, false),
                Repository("Second Local", "Owner 2", 200, true),
                Repository("Third Local", "Owner 3", 300, true)
        )
        return Observable.just(repositories).delay(2, TimeUnit.SECONDS)
    }

    fun saveRepositories(list: List<Repository>): Completable {
        return Single.just(1).delay(1, TimeUnit.SECONDS).toCompletable()
    }

}