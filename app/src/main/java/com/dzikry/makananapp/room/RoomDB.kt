package com.dzikry.makananapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dzikry.makananapp.model.RestoranItem

@Database (entities = [RestoranItem::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {
    abstract fun roomDao() : RoomDao


    companion object {
        private var roomdatabaseitem : RoomDB? = null

        fun getRoomDatabaseItem(context: Context): RoomDB{
            return roomdatabaseitem ?: synchronized(this){
                roomdatabaseitem ?: Room.databaseBuilder(context,RoomDB::class.java, "item.db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
        }
    }
}