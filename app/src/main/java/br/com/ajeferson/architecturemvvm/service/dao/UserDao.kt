package br.com.ajeferson.architecturemvvm.service.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import br.com.ajeferson.architecturemvvm.service.model.User
import io.reactivex.Single

/**
 * Created by ajeferson on 02/02/2018.
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getUsers(): Single<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<User>)

}