package com.daveleron.kotlincomposespotifyjanitor.model

import com.google.gson.annotations.SerializedName

data class AlbumImage(
    @SerializedName("height")
    val height : Int,

    @SerializedName("width")
    val width : Int,

    @SerializedName("url")
    val url : String
)
