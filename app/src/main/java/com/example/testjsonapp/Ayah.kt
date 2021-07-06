package com.example.testjsonapp

import android.os.Parcel
import android.os.Parcelable

data class Ayah(

    var idRacine: Int ,
    var texteAR: String? ="",


):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idRacine)
        parcel.writeString(texteAR)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Ayah> {
        override fun createFromParcel(parcel: Parcel): Ayah {
            return Ayah(parcel)
        }

        override fun newArray(size: Int): Array<Ayah?> {
            return arrayOfNulls(size)
        }
    }
}