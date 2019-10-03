package com.vitcon.myapplication

import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(),handleAsyntask {

    private var isDone : Boolean = true;

    override fun updateDataProgress(progress: Int) {
        txt_content.text = progress.toString()
    }

    override fun updateDataSuccess(result: String) {
        isDone = true
        txt_content.text = result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var pt : PhuongTien = intent.getParcelableExtra("data")
        txt_content.text = "${pt.name} - ${pt.mau} - ${pt.soBanh}"
        pt.soBanh = 3
        txt_content.setOnClickListener({
            var intent :Intent = Intent()
            intent.putExtra("data",pt)
            intent.putExtra("data2",3)
            setResult(0, intent)
            finish()
        })

        button_asyntask.setOnClickListener({
            if (isDone){
                isDone = false;
//                DemoAsynTask.newInstance(this).execute()  //demo singleton
                DemoAsynTask(this).execute()
            }
        })
    }

}
