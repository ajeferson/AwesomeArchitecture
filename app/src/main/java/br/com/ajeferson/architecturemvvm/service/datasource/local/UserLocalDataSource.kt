package br.com.ajeferson.architecturemvvm.service.datasource.local

import android.util.Log
import br.com.ajeferson.architecturemvvm.service.dao.UserDao
import br.com.ajeferson.architecturemvvm.service.model.User
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by ajeferson on 27/01/2018.
 */
class UserLocalDataSource @Inject constructor() {

    @Inject
    lateinit var dao: UserDao

    fun getUsers(): Observable<List<User>> {
        return dao.getUsers().toObservable()
    }

    fun saveUsers(list: List<User>) {
        Observable.fromCallable { dao.insertAll(list) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe {
                    Log.d("DB", "Saved ${list.size} users")
                }
    }

}