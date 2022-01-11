package com.example.cafeconleche

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeconleche.database.LlistaComanda
import com.example.cafeconleche.menjarDatabase.LlistaMenjars

class OrdenesListaAdapter(private val context: Context,
                          private val list: List<LlistaComanda>
): RecyclerView.Adapter<OrdenesListaAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val plat1: TextView = view.findViewById(R.id.nomTextView)
        val plat2: TextView = view.findViewById(R.id.descTextView)
        val postre: TextView = view.findViewById(R.id.preuTextView)
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
        holder.plat1.text = data.plat1
        holder.plat2.text = data.plat2
        holder.postre.text = data.postre
    }
}