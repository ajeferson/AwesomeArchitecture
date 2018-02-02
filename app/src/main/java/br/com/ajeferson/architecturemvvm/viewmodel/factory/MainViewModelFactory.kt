package br.com.ajeferson.architecturemvvm.viewmodel.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.ajeferson.architecturemvvm.service.repository.UserRepository
import br.com.ajeferson.architecturemvvm.viewmodel.MainViewModel

/**
 * Created by ajeferson on 31/01/2018.
 */
class MainViewModelFactory(private val userRepository: UserRepository): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Something")
    }

}