package br.com.ajeferson.architecturemvvm.extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by ajeferson on 29/01/2018.
 */
operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}