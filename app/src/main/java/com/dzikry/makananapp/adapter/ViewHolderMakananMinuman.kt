package com.dzikry.makananapp.adapter

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dzikry.makananapp.databinding.ItemRecyclerBinding
import com.dzikry.makananapp.fragment.MinumanFragment
import com.dzikry.makananapp.model.MakananItem

class ViewHolderMakananMinuman(val minumanBinding: ItemRecyclerBinding) : RecyclerView.ViewHolder(minumanBinding.root) {
    fun bind(minumanItem: MakananItem){
        val adapterMakanMinumItem = MakananAdapter()
        itemView.run {
            minumanBinding.textView.text = minumanItem.title
            minumanBinding.recpres.setHasFixedSize(true)
            minumanBinding.recpres.layoutManager = LinearLayoutManager(context)
            minumanBinding.recpres.adapter = adapterMakanMinumItem
        }
        adapterMakanMinumItem.addData(minumanItem.data)
        adapterMakanMinumItem.notifyDataSetChanged()
    }

}
