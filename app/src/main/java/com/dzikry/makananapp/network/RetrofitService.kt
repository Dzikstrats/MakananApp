package com.dzikry.makananapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitService {

    //Client bertugas sebagai alat penghubung ke server database
    private val client = OkHttpClient.Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://makanan-a32e7-default-rtdb.asia-southeast1.firebasedatabase.app/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    //buildservice digunakan untuk membuat service sesuai interface retrofit
    fun <T> buildService(service: Class<T>) : T {
        return retrofit.create(service)
    }
}