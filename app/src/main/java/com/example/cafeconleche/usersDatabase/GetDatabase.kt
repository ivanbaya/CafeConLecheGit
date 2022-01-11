package com.example.cafeconleche.usersDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.cafeconleche.menjarDatabase.Menjar
import com.example.cafeconleche.menjarDatabase.MenjarDatabaseDAO
import java.util.concurrent.Executors

@Database(entities = [Usuaris::class, Menjar::class], version = 2, exportSchema = false)
abstract class GetDatabase : RoomDatabase() {

    abstract val userDatabaseDAO: UserDatabaseDAO
    abstract val menjarDatabaseDAO: MenjarDatabaseDAO

    companion object {

        @Volatile
        private var INSTANCE: GetDatabase? = null

        fun getInstance(context: Context): GetDatabase {
            synchronized(this) {
                var instance = INSTANCE
                var menjar = Menjar()
                val run = Runnable { getInstance(context).menjarDatabaseDAO.insertAll(menjar.populateData()!!); }

                if (instance == null) {
                    val callback = object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Executors.newSingleThreadScheduledExecutor().execute(run)
                        }
                    }
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GetDatabase::class.java,
                        "cafeDatabase"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .addCallback(callback)
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}