package com.daveleron.kotlincomposespotifyjanitor.network

import com.daveleron.kotlincomposespotifyjanitor.model.AlbumResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface SpotifyApiInterface {

    @GET("me/albums")
    suspend fun getMyAlbums(@Header("Authorization") authHeader : String): AlbumResponse
}