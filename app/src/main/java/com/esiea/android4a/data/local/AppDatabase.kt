package com.esiea.android4a.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.esiea.android4a.data.local.models.UserLocal

@Database(entities = [UserLocal::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}