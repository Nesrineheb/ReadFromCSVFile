package com.example.testjsonapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "quran_table")
data class Quran(
    @PrimaryKey
    var idRacine: Int ,
    var texteAR: String? ="",







    )



