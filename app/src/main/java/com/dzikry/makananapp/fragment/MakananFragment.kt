package com.dzikry.makananapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzikry.makananapp.R
import com.dzikry.makananapp.adapter.MakananAdapter
import com.dzikry.makananapp.databinding.FragmentMakananBinding
import com.dzikry.makananapp.model.RestoranItem
import com.dzikry.makananapp.network.RetrofitInterface
import com.dzikry.makananapp.network.RetrofitService
import com.dzikry.makananapp.room.RoomDB
import kotlinx.coroutines.launch


class MakananFragment : Fragment() {

    private lateinit var binding: FragmentMakananBinding
    private lateinit var makananAdapter: MakananAdapter
    private lateinit var roomDB: RoomDB


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMakananBinding.inflate(inflater,container,false)

        roomDB = context?.let { RoomDB.getRoomDatabaseItem(it) }!!

        makananAdapter = MakananAdapter()
        binding.recyclermakanan.adapter = makananAdapter
        binding.recyclermakanan.setHasFixedSize(true)
        binding.recyclermakanan.layoutManager = LinearLayoutManager(context)


        return (binding.root)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var dataItemMakanan = roomDB.roomDao().getDatabyType("Makanan")

        dataItemMakanan.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()){
                makananAdapter.addData(it)
                makananAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(context, "Database Kosong", Toast.LENGTH_SHORT).show()

                val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)

                viewLifecycleOwner.lifecycleScope.launch {
                    val mintadataMakanan = retrofitService.getDataRestoran()
                    //kondisi saat sukses show data
                    if (mintadataMakanan.isSuccessful){
                        val dataMakanan = mintadataMakanan.body() as List<RestoranItem>
                        dataMakanan.forEach {
                            it.type = "Makanan"
                        }
                        roomDB.roomDao().insertData(dataMakanan)
                    }
                }
            }
        })



    }

}