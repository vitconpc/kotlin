package com.vitcon.myapplication

import android.os.Parcel
import android.os.Parcelable

data class PhuongTien(var name: String, var mau: String, var soBanh: Int) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(mau)
        parcel.writeInt(soBanh)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PhuongTien> {
        override fun createFromParcel(parcel: Parcel): PhuongTien {
            return PhuongTien(parcel)
        }

        override fun newArray(size: Int): Array<PhuongTien?> {
            return arrayOfNulls(size)
        }
    }

    fun dangKyXe(sinhVien: SinhVien, notify : (bienSoXe : Int) -> String): String{
        // dang ky
        // co bien so xe
         return notify(123)
    }

}
//Data class: chứa dữ liệu
