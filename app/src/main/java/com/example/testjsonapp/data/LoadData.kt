package com.example.testjsonapp.data

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

object LoadData {

    fun getAllDatabase(context: Context):List<Quran>{
        val ayas = mutableListOf<Quran>()
        try {
            val csvfile = InputStreamReader(context.assets.open("qurandata.csv"))
            val csvfilereader = BufferedReader(csvfile)
            var nextLine= csvfilereader.readLine()
            nextLine= csvfilereader.readLine()
            while (nextLine!= null) {
                val data = nextLine.split(',')
                ayas.add(Quran(data[0].toInt(),data[1]))
                nextLine= csvfilereader.readLine()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ayas
    }
}