package com.example.testjsonapp.data


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuranDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMotCoran(motCoran: Quran)



    @Insert
    suspend fun insertAll(Coran: List<Quran>)
}