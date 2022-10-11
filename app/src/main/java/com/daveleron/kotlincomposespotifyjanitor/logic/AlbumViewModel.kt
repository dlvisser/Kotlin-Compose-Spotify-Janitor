package com.daveleron.kotlincomposespotifyjanitor.logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.daveleron.kotlincomposespotifyjanitor.network.SpotifyApiClient
import com.daveleron.kotlincomposespotifyjanitor.network.SpotifyApiResponse
import kotlinx.coroutines.Dispatchers

class AlbumViewModel() : ViewModel() {
    fun getAlbumData() = liveData(Dispatchers.IO) {
        emit(SpotifyApiResponse.loading(data = null))
        try {
            emit(SpotifyApiResponse.success(data = SpotifyApiClient.API_SERVICE.getMyAlbums("Bearer BQDiYKG3wYDkCMsgkE6EeZHlM0SxxtO9NCWRZ1NbakJlSjeOroJ08EO4x926DjZRWnGK81piNHY2gSTofZ_fKtsYbjKS5Ieq4kEdW7H4dNjMsbny48zrHhUzSM1r1OUar6R1wHcKiH_Lg8qvY2nekUlIDASPl6lnkOcvQN-9WSx5_isGwN06a2YS01V00Ff2kJ76rJStrkpRuzV71L329A")))
        } catch (exception: Exception) {
            emit(SpotifyApiResponse.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}