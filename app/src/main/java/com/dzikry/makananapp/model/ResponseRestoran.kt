package com.dzikry.makananapp.model

import com.squareup.moshi.Json

data class ResponseRestoran(

	@Json(name="ResponseRestoran")
	val responseRestoran: List<ResponseRestoranItem?>? = null
)

data class ResponseRestoranItem(

	@Json(name="judul_restoran")
	val judul_restoran: String? = null,

	@Json(name="desk_restoran")
	val desk_restoran: String? = null,

	@Json(name="gambar")
	val gambar: String? = null
)
