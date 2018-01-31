package br.com.ajeferson.architecturemvvm.di.module

import br.com.ajeferson.architecturemvvm.viewmodel.MainViewModel
import dagger.Module

/**
 * Created by ajeferson on 31/01/2018.
 */
@Module
class ViewModelModule(private val viewModel: MainViewModel) {

    // Provide ViewModel dependencies specific over here

}