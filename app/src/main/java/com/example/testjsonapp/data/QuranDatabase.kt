package com.example.testjsonapp.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Quran::class], version = 1, exportSchema = false)
abstract class QuranDatabase:RoomDatabase() {


    abstract fun addAll(): QuranDao
    abstract fun insertAll(): QuranDao





}