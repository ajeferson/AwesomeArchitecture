package br.com.ajeferson.architecturemvvm.service.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by ajeferson on 26/01/2018.
 */
@Entity(tableName = "users")
data class User(

        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: Int,

        @ColumnInfo(name = "name")
        val name: String?,

        @ColumnInfo(name = "email")
        val email: String?,

        @ColumnInfo(name = "username")
        val username: String? = null)