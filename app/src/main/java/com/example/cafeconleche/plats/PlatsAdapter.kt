package com.example.cafeconleche.plats

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeconleche.R
import com.example.cafeconleche.database.menjar.Menjar

class PlatsAdapter(private val context: Context,
                   private val list: List<Menjar>,
                   private val model: SharedViewModel): RecyclerView.Adapter<PlatsAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nom: TextView = view.findViewById(R.id.plat1TextView)
        val desc: TextView = view.findViewById(R.id.plat2TextView)
        val preu: TextView = view.findViewById(R.id.postreTextView)
        val fav: ImageView = view.findViewById(R.id.corazon)
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

        holder.fav.setImageResource(R.drawable.corazon)

        holder.itemView.setOnLongClickListener {
            holder.fav.setImageResource(R.drawable.corazon_favorito)
            true
        }
        holder.itemView.setOnClickListener {
            if(data.tipus == "Plat1"){
                model.sendPreu1(data.preu)
                model.sendPlat1(data.nom)
            }else if(data.tipus == "Plat2"){
                model.sendPreu2(data.preu)
                model.sendPlat2(data.nom)
            }else{
                model.sendPreu3(data.preu)
                model.sendPostre(data.nom)
            }
        }
    }
}