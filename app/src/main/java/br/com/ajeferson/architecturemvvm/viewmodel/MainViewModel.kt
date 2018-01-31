package br.com.ajeferson.architecturemvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import br.com.ajeferson.architecturemvvm.common.App
import br.com.ajeferson.architecturemvvm.common.NetManager
import br.com.ajeferson.architecturemvvm.di.components.DaggerViewModelComponent
import br.com.ajeferson.architecturemvvm.di.modules.ViewModelModule
import br.com.ajeferson.architecturemvvm.service.repository.GitRepoRepository
import br.com.ajeferson.architecturemvvm.service.model.Repository
import br.com.ajeferson.architecturemvvm.extensions.plusAssign
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
class MainViewModel(application: Application) : BaseViewModel(application) {

    private  var gitRepoRepository = GitRepoRepository(getApplication())
    private var compositeDisposable = CompositeDisposable()

    val text = ObservableField("old data")
    val isLoading = ObservableField(false)
    var repositories = MutableLiveData<List<Repository>>()

    fun loadRepositories() {
        isLoading.set(true)
        compositeDisposable += gitRepoRepository
                .getGitRepositories()
                .subscribeOn(Schedulers.newThread()) // Which thread the observable will be created
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableObserver<List<Repository>>() {

            override fun onComplete() {
                isLoading.set(false)
            }

            override fun onNext(data: List<Repository>) {
                repositories.value = data
            }

            override fun onError(e: Throwable) {
                // TODO
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