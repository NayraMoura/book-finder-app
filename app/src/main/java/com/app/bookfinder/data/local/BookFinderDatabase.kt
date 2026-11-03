package com.app.bookfinder.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class BookFinderDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: BookFinderDatabase? = null

        fun getDatabase(context: Context): BookFinderDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookFinderDatabase::class.java,
                    "book_finder_database",
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}