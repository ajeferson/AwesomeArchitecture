package br.com.ajeferson.architecturemvvm.common

import android.arch.persistence.room.*
import android.arch.persistence.room.Database
import br.com.ajeferson.architecturemvvm.service.dao.UserDao
import br.com.ajeferson.architecturemvvm.service.model.User

/**
 * Created by ajeferson on 02/02/2018.
 */

private const val DATABASE_VERSION = 1

@Database(entities = [User::class], version = DATABASE_VERSION)
abstract class Database: RoomDatabase() {

    abstract fun userDao(): UserDao

}