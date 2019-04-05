package com.example.msimple.persistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.msimple.data.vos.LoginUserVO;
import com.example.msimple.persistance.dao.LoginUserDao;

@Database(entities = LoginUserVO.class, version = 1)
public abstract class SimpleHabitDb extends RoomDatabase {

    private static final String DB_NAME = "news_database.DB";
    public static SimpleHabitDb simpleHabitDb;

    public SimpleHabitDb() {
    }

    public static SimpleHabitDb getInstance(Context context) {


        if (simpleHabitDb == null) {
            simpleHabitDb = Room.databaseBuilder(context, SimpleHabitDb.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }

        return simpleHabitDb;
    }
    public abstract LoginUserDao getLoginDao();


}

