package br.com.ajeferson.architecturemvvm.common

import android.content.Context
import android.net.ConnectivityManager
import br.com.ajeferson.architecturemvvm.di.annotation.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ajeferson on 27/01/2018.
 */
@Singleton
class NetManager @Inject constructor(@ApplicationContext private var applicationContext: Context) {

    val isConnectedToInternet: Boolean?
        get() {
            val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val ni = conManager.activeNetworkInfo
            return ni != null && ni.isConnected
        }

}