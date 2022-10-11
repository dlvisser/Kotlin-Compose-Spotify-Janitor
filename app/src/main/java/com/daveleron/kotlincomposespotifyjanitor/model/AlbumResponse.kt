package com.daveleron.kotlincomposespotifyjanitor.model

import com.google.gson.annotations.SerializedName

data class AlbumResponse(

    @SerializedName("items")
    val albumItems : ArrayList<AlbumItems>,
    )