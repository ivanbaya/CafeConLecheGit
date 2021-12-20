package com.example.cafeconleche

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeconleche.database.LlistaComanda

class OrdenesListaAdapter(private val context: Context,
                          private val list: List<LlistaComanda>): RecyclerView.Adapter<OrdenesListaAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nametv: TextView = view.findViewById(R.id.plat1TextView)
        val primertv: TextView = view.findViewById(R.id.plat2TextView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_ordenes,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.nametv.text = data.plat1
        holder.primertv.text = data.plat2
    }
}