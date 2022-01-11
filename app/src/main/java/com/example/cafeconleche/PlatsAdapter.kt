package com.example.cafeconleche

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeconleche.menjarDatabase.Menjar

class PlatsAdapter(private val context: Context,
                   private val list: List<Menjar>): RecyclerView.Adapter<PlatsAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nom: TextView = view.findViewById(R.id.nomTextView)
        val desc: TextView = view.findViewById(R.id.descTextView)
        val preu: TextView = view.findViewById(R.id.preuTextView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_menjar,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.nom.text = data.nom
        holder.desc.text = data.descripcio
        holder.preu.text = data.preu.toString()
    }
}