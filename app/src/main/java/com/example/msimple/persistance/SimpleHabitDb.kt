package com.example.msimple.persistance

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

import com.example.msimple.data.vos.LoginUserVO
import com.example.msimple.persistance.dao.LoginUserDao

@Database(entities = [LoginUserVO::class], version = 1)
abstract class SimpleHabitDb : RoomDatabase() {
    abstract val loginDao: LoginUserDao

    companion object {

        private val DB_NAME = "news_database.DB"
        var simpleHabitDb: SimpleHabitDb? = null

        fun getInstance(context: Context): SimpleHabitDb {


            if (simpleHabitDb == null) {
                simpleHabitDb = Room.databaseBuilder(context, SimpleHabitDb::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()
            }

            return simpleHabitDb
        }
    }


}

