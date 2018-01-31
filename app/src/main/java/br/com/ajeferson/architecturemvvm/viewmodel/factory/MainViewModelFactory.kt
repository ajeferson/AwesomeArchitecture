package br.com.ajeferson.architecturemvvm.viewmodel.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.ajeferson.architecturemvvm.service.repository.GitRepoRepository
import br.com.ajeferson.architecturemvvm.viewmodel.MainViewModel

/**
 * Created by ajeferson on 31/01/2018.
 */
class MainViewModelFactory(val gitRepoRepository: GitRepoRepository): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(gitRepoRepository) as T
        }
        throw IllegalArgumentException("Something")
    }

}