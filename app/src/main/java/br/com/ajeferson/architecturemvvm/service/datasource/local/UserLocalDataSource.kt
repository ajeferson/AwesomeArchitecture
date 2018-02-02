package br.com.ajeferson.architecturemvvm.service.datasource.local

import br.com.ajeferson.architecturemvvm.service.model.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by ajeferson on 27/01/2018.
 */
class UserLocalDataSource @Inject constructor() {

    fun getUsers(): Observable<List<User>> {
        val users = listOf(
                User("Jon Snow", "jon.snow@email.com"),
                User("Eddard Stark", "eddard.stark@email.com", "ned"),
                User("Daenerys Targaryen", "daenerys.targaryen@gmail.com", "mother.of.dragons")
        )
        return Observable.just(users).delay(2, TimeUnit.SECONDS)
    }

    fun saveUsers(list: List<User>): Completable {
        return Single.just(1).delay(1, TimeUnit.SECONDS).toCompletable()
    }

}