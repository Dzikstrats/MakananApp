package com.dzikry.makananapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dzikry.makananapp.model.RestoranItem

@Dao
interface RoomDao {

    //menampilkan data semua sesuai typenya
    @Query ("SELECT * FROM item WHERE type = :type")
    fun getDatabyType (type: String) : LiveData<List<RestoranItem>>

//    @Query("DELETE FROM item")
//    suspend fun resetDatabase()
//
//    @Query("DELETE FROM item WHERE type = :type")
//    suspend fun resetType(type: String)

    @Insert
    suspend fun insertData(data:List<RestoranItem>)
}