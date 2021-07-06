package com.example.testjsonapp.data

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class RoomService {
    private var dataBase :QuranDatabase ?=null
    fun getDataBase (context: Context):QuranDatabase{

        if(dataBase==null){
            Room.databaseBuilder(context,QuranDatabase::class.java)
                .allowMainThreadQueries()
                .addCallback(object :RoomDatabase.Callback(){

                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Log.d("test","dkhol")
                        Executors.newSingleThreadExecutor().execute{
                            dataBase.getQuranDao().insertAll(LoadData.getAllDatabase())
                        }

                    }
                })

        }
    }


}