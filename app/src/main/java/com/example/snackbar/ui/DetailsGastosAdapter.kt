package com.example.snackbar.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.snackbar.R
import com.example.snackbar.domain.Gasto

class DetailsGastosAdapter (private val listGastos: List<Gasto>) : RecyclerView.Adapter<DetailsGastosAdapter.DetailGastosViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailGastosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_gasto,  parent, false)
        return DetailGastosViewHolder(itemView)
    }

    override fun onBindViewHolder (holder: DetailGastosViewHolder , position: Int) {
        val currentItem = listGastos [position]
        holder.tvDescricao.setText(currentItem.descricao)
    }

    override fun getItemCount () = listGastos.size





    class DetailGastosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val tvDescricao : TextView = itemView.findViewById(R.id.tvDescricao)

    }
}