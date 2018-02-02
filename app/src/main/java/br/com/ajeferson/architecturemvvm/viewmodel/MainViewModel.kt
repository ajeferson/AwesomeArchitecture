package br.com.ajeferson.architecturemvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import br.com.ajeferson.architecturemvvm.service.repository.UserRepository
import br.com.ajeferson.architecturemvvm.service.model.User
import br.com.ajeferson.architecturemvvm.extension.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * VIEW_MODEL
 * Holds data
 * Has logic for when the data should be FETCHED
 * Has logic for when the data should be PRESENTED
 * Holds the current STATE
 * Holds reference to 0..n Models
 * Data should be fetched from Models
 * Should not care about how data is fetched
 * Should not know about the VIEW
 * Should not know about Android Framework
 * Exposes streams of data relevant to the VIEW
 * Exposes state for the VIEW
 */
class MainViewModel(private val userRepository: UserRepository) : ViewModel() {

    private var compositeDisposable = CompositeDisposable()

    val text = ObservableField("old data")
    val isLoading = ObservableField(false)
    val hasError = ObservableField(false)
    var users = MutableLiveData<List<User>>()

    fun loadUsers() {
        isLoading.set(true)
        compositeDisposable += userRepository
                .getUsers()
                .subscribeOn(Schedulers.newThread()) // Which thread the observable will be created
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableObserver<List<User>>() {

            override fun onComplete() {
                isLoading.set(false)
                hasError.set(false)
            }

            override fun onNext(data: List<User>) {
                users.value = data
            }

            override fun onError(e: Throwable) {
                isLoading.set(false)
                hasError.set(true)
            }

        })
    }

    /**
     * Gets called the the activity is actually destroyed
     * */
    override fun onCleared() {
        super.onCleared()
        if(!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

}