package com.daveleron.kotlincomposespotifyjanitor.model

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("album_type")
    val albumType : String,

    @SerializedName("name")
    val name : String,

    @SerializedName("images")
    val images : ArrayList<AlbumImage>,

    @SerializedName("uri")
    val uri : String
)