package br.com.ajeferson.architecturemvvm.service.datasource.remote

import br.com.ajeferson.architecturemvvm.common.NetManager
import br.com.ajeferson.architecturemvvm.service.model.Repository
import dagger.Reusable
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by ajeferson on 27/01/2018.
 */
@Reusable
class GitRepoRemoteDataSource @Inject constructor() {

    @Inject
    lateinit var netManager: NetManager

    fun getGitRepositories(): Observable<List<Repository>> {
        val repositories = listOf(
                Repository("First Remote", "Owner 1", 100, false),
                Repository("Second Remote", "Owner 2", 200, true),
                Repository("Third Remote", "Owner 3", 300, true)
        )
        return Observable.just(repositories).delay(2, TimeUnit.SECONDS)
    }

}