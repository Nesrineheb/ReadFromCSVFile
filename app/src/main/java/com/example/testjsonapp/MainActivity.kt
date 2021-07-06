package com.example.testjsonapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity :  AppCompatActivity(), View.OnClickListener {
    lateinit var adapter: ListAyaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        val ayas2 = mutableListOf<Ayah>()
        var aya :Ayah
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("1")
        ayas2.addAll(getAllDatabase())
        println("ayas.get(1)")
        aya=ayas2.get(1)

        println(ayas2.get(1).texteAR)
        adapter=ListAyaAdapter(ayas2, this)
        val recyclerView = findViewById(R.id.ayah_recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    fun getAllDatabase():List<Ayah>{
        val ayas = mutableListOf<Ayah>()
        try {
            val csvfile = InputStreamReader(assets.open("qurandata.csv"))
            val csvfilereader = BufferedReader(csvfile)
            var nextLine= csvfilereader.readLine()
            nextLine= csvfilereader.readLine()
            while (nextLine!= null) {
                val data = nextLine.split(',')
                ayas.add(Ayah(data[1].toInt(),data[11]))
                nextLine= csvfilereader.readLine()

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ayas
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}