package com.daveleron.kotlincomposespotifyjanitor.model

import com.google.gson.annotations.SerializedName

data class AlbumItems(
    @SerializedName("added_at")
    val addedDate : String,

    @SerializedName("album")
    val album : Album
)
