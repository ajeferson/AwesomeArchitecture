package br.com.ajeferson.architecturemvvm.service.datasource.remote

import br.com.ajeferson.architecturemvvm.service.model.User
import io.reactivex.Observable
import retrofit2.http.GET
import javax.inject.Inject

/**
 * Created by ajeferson on 27/01/2018.
 */
class UserRemoteDataSource @Inject constructor() {

    @Inject
    lateinit var api: Api

    fun getUsers(): Observable<List<User>> {
        return api.index()
    }

    interface Api {

        @GET("/users")
        fun index(): Observable<List<User>>

    }

}