package com.dzikry.makananapp.network

import com.dzikry.makananapp.model.MakananItem
import com.dzikry.makananapp.model.RestoranItem
import retrofit2.Response

import retrofit2.http.GET

interface RetrofitInterface {
    @GET("Data/Restoran.json")
    suspend fun getDataRestoran() : Response<List<RestoranItem>>

    @GET("Data/Kategori_Minuman.json")
    suspend fun getDataMinuman()

    @GET("Data/Kategori_Makanan.json")
    suspend fun getDataMakanan() : Response<List<MakananItem>>


}