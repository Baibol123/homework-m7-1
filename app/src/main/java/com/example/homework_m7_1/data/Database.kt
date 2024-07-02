package com.example.homework_m7_1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Camera::class, Door::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val cameraDao: CameraDao
    abstract val doorDao: DoorDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

@Database(
    entities = [Camera::class], version = 1
)
abstract class CameraDatabase : RoomDatabase() {
    abstract val cameraDao: CameraDao
}

@Database(
    entities = [Door::class], version = 1
)
abstract class DoorDatabase : RoomDatabase() {
    abstract val doorDao: DoorDao
}