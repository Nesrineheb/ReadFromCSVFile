package com.example.testjsonapp

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader


object Utils {
    fun getAllDatabase(context:Context):List<Ayah>{
        val ayas = mutableListOf<Ayah>()
        try {
            val csvfile = InputStreamReader(context.assets.open("qurandata.csv"))
            val csvfilereader = BufferedReader(csvfile)
            var nextLine= csvfilereader.readLine()
            nextLine= csvfilereader.readLine()
            while (nextLine!= null) {
                val data = nextLine.split(',')
                ayas.add(Ayah(data[0].toInt(),data[10]))
                nextLine= csvfilereader.readLine()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ayas
    }
}