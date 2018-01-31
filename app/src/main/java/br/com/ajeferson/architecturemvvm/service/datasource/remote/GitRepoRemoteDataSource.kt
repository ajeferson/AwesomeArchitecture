package br.com.ajeferson.architecturemvvm.service.datasource.remote

import br.com.ajeferson.architecturemvvm.common.NetManager
import br.com.ajeferson.architecturemvvm.service.model.Repository
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

/**
 * Created by ajeferson on 27/01/2018.
 */
class GitRepoRemoteDataSource @Inject constructor() {

    @Inject
    lateinit var api: Api

    fun getGitRepositories(): Observable<List<Repository>> {
        return api.index()
    }

    interface Api {

        @GET("/repositories")
        fun index(): Observable<List<Repository>>

    }

}