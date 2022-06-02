package com.dzikry.makananapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzikry.makananapp.R
import com.dzikry.makananapp.adapter.MakananMinumanAdapter
import com.dzikry.makananapp.databinding.FragmentMinumanBinding
import com.dzikry.makananapp.model.MakananItem
import com.dzikry.makananapp.model.RestoranItem
import com.dzikry.makananapp.network.RetrofitInterface
import com.dzikry.makananapp.network.RetrofitService
import com.dzikry.makananapp.room.RoomDB
import kotlinx.coroutines.launch


class MinumanFragment : Fragment() {

    private lateinit var binding : FragmentMinumanBinding
    private lateinit var adapterMakanMinum : MakananMinumanAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMinumanBinding.inflate(inflater, container, false)

        adapterMakanMinum = MakananMinumanAdapter()
        binding.recyclermakanminum.setHasFixedSize(true)
        binding.recyclermakanminum.layoutManager = LinearLayoutManager(context)
        binding.recyclermakanminum.adapter = adapterMakanMinum

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val mintadataMinuman = retrofitService.getDataMakanan()
            if (mintadataMinuman.isSuccessful){
                val dataMinuman = mintadataMinuman.body() as List<MakananItem>
                adapterMakanMinum.addData(dataMinuman)
                adapterMakanMinum.notifyDataSetChanged()
            }
        }
    }

}