package com.example.cafeconleche.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LlistaComanda::class], version = 1, exportSchema = false)
abstract class ComandaDatabase : RoomDatabase() {

    abstract val comandaDatabaseDAO: ComandaDatabaseDAO

    companion object {

        @Volatile
        private var INSTANCE: ComandaDatabase? = null

        fun getInstance(context: Context): ComandaDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ComandaDatabase::class.java,
                        "comanda_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}