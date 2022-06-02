package com.dzikry.makananapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzikry.makananapp.R
import com.dzikry.makananapp.adapter.MakananMinumanAdapter

import com.dzikry.makananapp.databinding.FragmentMinumanBinding
import com.dzikry.makananapp.databinding.FragmentProfileBinding
import com.dzikry.makananapp.model.MakananItem

import com.dzikry.makananapp.network.RetrofitInterface
import com.dzikry.makananapp.network.RetrofitService
import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)



        return binding.root
    }


}