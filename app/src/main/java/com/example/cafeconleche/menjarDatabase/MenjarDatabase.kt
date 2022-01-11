package com.example.cafeconleche.menjarDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LlistaMenjars::class], version = 2, exportSchema = false)
abstract class MenjarDatabase : RoomDatabase() {

    abstract val menjarDatabaseDAO: MenjarDatabaseDAO

    companion object {

        @Volatile
        private var INSTANCE: MenjarDatabase? = null

        fun getInstance(context: Context): MenjarDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MenjarDatabase::class.java,
                        "cafeDatabase"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}