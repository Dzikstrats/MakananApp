package com.dzikry.makananapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dzikry.makananapp.databinding.ItemRecyclerBinding
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Entity(tableName = "item")
@Parcelize
data class RestoranItem(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    @Json(name = "gambar") //dari firebase
    var gambar: String?, //dari variable
    @Json(name = "judul")
    val judul : String?,
    @Json(name = "desk")
    val desk: String?,
    var type: String?
) : Parcelable

data class MakananItem(
    @Json(name = "title")
    var title : String?,
    var data: List<RestoranItem> = arrayListOf()
)
