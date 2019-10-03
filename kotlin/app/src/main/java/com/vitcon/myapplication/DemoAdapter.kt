package com.vitcon.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DemoAdapter : RecyclerView.Adapter<DemoAdapter.DemoViewHolder> {

    private var datas: MutableList<String>

    constructor(datas: MutableList<String>) : super() {
        this.datas = datas
//            .filter { s->s.length>3 }.toMutableList()
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): DemoViewHolder {
        if (viewType == 1) {
            return DemoViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_demo, null))
        }
        return DemoViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_demo_2, null))
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun getItemViewType(position: Int): Int {
        if (datas[position].length > 3) return 1
        return 0
    }

    override fun onBindViewHolder(p0: DemoViewHolder, p1: Int) {
        when(p0.itemViewType){
            1-> p0.tv_name.text = datas[p1]
            0->{p0.tv_name.text = datas[p1]}
        }

    }

    class DemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_name: TextView = itemView.findViewById(R.id.txt_content)
    }


}