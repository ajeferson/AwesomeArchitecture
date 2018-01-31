package br.com.ajeferson.architecturemvvm.di.modules

import br.com.ajeferson.architecturemvvm.viewmodel.BaseViewModel
import dagger.Module

/**
 * Created by ajeferson on 31/01/2018.
 */
@Module
class ViewModelModule(private val viewModel: BaseViewModel) {

    // Provide ViewModel dependencies specific over here

}