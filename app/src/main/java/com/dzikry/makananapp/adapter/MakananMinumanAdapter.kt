package com.dzikry.makananapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dzikry.makananapp.databinding.ItemRecyclerBinding
import com.dzikry.makananapp.model.MakananItem

class MakananMinumanAdapter : RecyclerView.Adapter<ViewHolderMakananMinuman>() {

    private val listitemminuman = arrayListOf<MakananItem>()
    fun addData(itemminuman : List<MakananItem>) {
        listitemminuman.clear()
        listitemminuman.addAll(itemminuman)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMakananMinuman {
        val itemkategoriminumanbinding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        return ViewHolderMakananMinuman(itemkategoriminumanbinding)
    }

    override fun onBindViewHolder(holder: ViewHolderMakananMinuman, position: Int) {
        val data = listitemminuman[position]
        holder.bind(data)


//        holder.itemView.setOnClickListener {
//            val intent = Intent(it.context, DetailActivity2::class.java)
//            intent.putExtra(DetailActivity2.Detail2_Data, data)
//            it.context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return listitemminuman.size
    }
}