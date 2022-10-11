package com.daveleron.kotlincomposespotifyjanitor.network

class SpotifyApiResponse<out T>(val myApiStatus: SpotifyApiStatus, val data: T?, val message: String?) {
     companion object {
            fun <T> success(data: T): SpotifyApiResponse<T> = SpotifyApiResponse(myApiStatus = SpotifyApiStatus.SUCCESS, data = data, message = null)
            fun <T> error(data: T?, message: String): SpotifyApiResponse<T> =
                SpotifyApiResponse(myApiStatus = SpotifyApiStatus.ERROR, data = data, message = message)

            fun <T> loading(data: T?): SpotifyApiResponse<T> = SpotifyApiResponse(myApiStatus = SpotifyApiStatus.LOADING, data = data, message = null)
        }
}

enum class SpotifyApiStatus {
    SUCCESS,
    ERROR,
    LOADING
}