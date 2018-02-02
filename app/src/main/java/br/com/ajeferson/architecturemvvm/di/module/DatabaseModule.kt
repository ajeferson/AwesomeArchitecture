package br.com.ajeferson.architecturemvvm.di.module

import android.arch.persistence.room.Room
import br.com.ajeferson.architecturemvvm.common.App
import br.com.ajeferson.architecturemvvm.common.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ajeferson on 02/02/2018.
 */
@Module
class DatabaseModule {

    // TODO Injection qualified of database name
    @Singleton
    @Provides
    fun provideDatabase(app: App): Database = Room.databaseBuilder(
            app.applicationContext,
            Database::class.java,
            "mvvm_architecture_database").build()

    @Singleton
    @Provides
    fun provideUserDato(database: Database) = database.userDao()

}
