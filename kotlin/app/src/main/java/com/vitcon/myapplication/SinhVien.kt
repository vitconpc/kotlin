package com.vitcon.myapplication

class SinhVien {
    var hoTen: String = ""
    var diaChi: String = ""
    private var namSinh: Int = 0

    constructor()

    constructor(name: String, address: String,birthday: Int){
        hoTen = name
        diaChi =address
        namSinh = birthday
    }
    fun setNamSinh(namSinh: Int) {
        if (namSinh > 2001) {
            this.namSinh = 0
            return
        }
        this.namSinh = namSinh
    }

    fun getNamSinh(): Int {
        return namSinh
    }
}