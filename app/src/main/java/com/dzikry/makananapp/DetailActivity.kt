package com.dzikry.makananapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dzikry.makananapp.databinding.ActivityDetailBinding
import com.dzikry.makananapp.model.RestoranItem

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    companion object {
        const val Detail_Data = "A"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<RestoranItem>(Detail_Data)

        binding.txtDetailjudulall.text = data?.judul
        binding.txtDetaildescall.text = data?.desk
        Glide.with(this).load(data?.gambar).into(binding.imgDetailall)
    }
}