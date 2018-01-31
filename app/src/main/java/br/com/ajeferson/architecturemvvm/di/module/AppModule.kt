package br.com.ajeferson.architecturemvvm.di.module

import android.content.Context
import br.com.ajeferson.architecturemvvm.di.annotation.ApplicationContext
import br.com.ajeferson.architecturemvvm.common.App
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by ajeferson on 30/01/2018.
 */

private const val BASE_URL = "http://www.test.com/"

@Module
class AppModule(private val app: App) {

    @Provides
    @ApplicationContext
    fun provideContext(): Context = app.applicationContext

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}