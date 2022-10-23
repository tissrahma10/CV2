package com.example.curriculumvitae2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [ExprienceEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun ExpDao(): ExprienceDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, AppDataBase::class.java, "expriencedb")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return instance!!
        }
    }
}