package com.dzikry.makananapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dzikry.makananapp.DetailActivity
import com.dzikry.makananapp.databinding.ItemRestoranBinding
import com.dzikry.makananapp.model.RestoranItem

class MakananAdapter : RecyclerView.Adapter<MakananViewHolder>() {
    private var listitemmakanan = arrayListOf<RestoranItem>()

    fun addData(items : List<RestoranItem>){
        listitemmakanan.addAll(items)

    }

    //oncreate view holder untuk menampilkan layout item yang digunakan untuk recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakananViewHolder {
        val listitemmakananbinding = ItemRestoranBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MakananViewHolder(listitemmakananbinding)

    }

    override fun onBindViewHolder(holder: MakananViewHolder, position: Int) {
        val data = listitemmakanan[position]
        holder.bindview(data)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.Detail_Data, data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listitemmakanan.size
    }

}