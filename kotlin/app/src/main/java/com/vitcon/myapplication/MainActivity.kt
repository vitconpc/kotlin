package com.vitcon.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var datas: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        datas = ArrayList()
        datas.add("one")
        datas.add("two")
        datas.add("three")
        datas.add("four")
        datas.add("five")
        datas.add("six")
        datas.add("seven")
        datas.add("eight")
        datas.add("nine")
        datas.add("ten")

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.addItemDecoration(DividerItemDecoration(recycler_view.context,DividerItemDecoration.VERTICAL))
        recycler_view.adapter = DemoAdapter(datas)
        var phuongTien = PhuongTien("", "", 1)
        phuongTien.dangKyXe(SinhVien(), {bienSoXe ->
             "$bienSoXe abc"
            bienSoXe.toString()
        })

        //todo Khai báo biến
//        var a : String = "hello"
//        a = "fat"
//        a.toInt() // var có thể thay đổi, gán dữ liệu
//        val b : String = "fat" // val : chỉ lấy ra dùng, ko sửa được, giống hằng số

//        var a: Int ? = 2

        // ? là giá trị đó có thể gán bằng null đặt sau kiểu dữ liệu :  var a: String ? "hello"   a = null // run ok
        //!! là không được set giá trị cho biến này là null
//
//        when (a) {
//            1,2,3 -> {
//                Log.d("AAA"," 1 đến 3")
//            }
//            in 4..9 -> {
//                Log.d("AAA","4 đến 9")
//            }
//        }
//
//        for (i in 1..10){ // duyệt từ 1 đến 10
//            Log.d("AAA","one = "+ i)
//        }
//
//        for (i in 1 until 3){ //duyệt từ 1 đến <3
//            Log.d("AAA","up to = "+ i)
//        }
//
//        for (i in 3 downTo  1){ //duyệt từ 3 tới 1
//            Log.d("AAA","down = "+ i)
//        }
//
//        for (i in 1..10 step 3){
//            Log.d("AAA","two = "+ i)
//        }


        // C1   var mangSo : IntArray = intArrayOf(1,2,3,4,5)

//        C2
//        var mangTen : List<String> = listOf("A","B","C","D")
//        Log.d("AAA","two = "+ mangTen.get(2))

        //C3
//        var mangTen : ArrayList<String> = ArrayList()
//        mangTen.add("A")
//        mangTen.add("B")
//        mangTen.add("C")
//        mangTen.add("D")

//        mangTen.remove("C")
//        mangTen.removeAt(2)

//        mangTen.set(2,"Ahihi")
//
//        Log.d("AAA","two = "+ mangTen.get(2))

//        showName("Việt")
//        Log.d("AAA","two = "+ showName("a").size)

        var student : SinhVien = SinhVien()
        student.diaChi = "a"
        student.hoTen = "a1"
        student.setNamSinh(2001)

        Log.d("AAA","Sinh viên: ${student.hoTen}")

        Log.d("AAA",student.hoTen)
        Log.d("AAA",student.diaChi)
        Log.d("AAA",student.getNamSinh().toString())

        deMo.text = "5"
        var so : Int = deMo.text.toString().toInt()
        deMo.setOnClickListener({
            Toast.makeText(this,"show text : $so",Toast.LENGTH_SHORT).show()
        })

        button_click.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                MethodCommon.demo(this@MainActivity)
                var intent : Intent = Intent(this@MainActivity,SecondActivity::class.java)
                var phuongTien: PhuongTien = PhuongTien("xe may","den",2)
                intent.putExtra("data",phuongTien)
                startActivityForResult(intent,1)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==1 && resultCode == 0 && data!=null){
            var pt : PhuongTien = data.getParcelableExtra("data")
            deMo.text = "${pt.soBanh}"
        }
    }

    fun showName(ten : String) : ArrayList<String>{
//        Log.d("AAA","Xin chào "+ ten)
        var mang : ArrayList<String> = ArrayList()
        mang.add("a")
        mang.add("a1")
        mang.add("a2")
        return mang
    }

}
