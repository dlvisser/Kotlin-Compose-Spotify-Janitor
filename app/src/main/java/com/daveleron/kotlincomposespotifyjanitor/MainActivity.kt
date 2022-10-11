package com.daveleron.kotlincomposespotifyjanitor

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.Observer
import com.daveleron.kotlincomposespotifyjanitor.logic.AlbumViewModel
import com.daveleron.kotlincomposespotifyjanitor.model.AlbumItems
import com.daveleron.kotlincomposespotifyjanitor.network.SpotifyApiStatus
import com.daveleron.kotlincomposespotifyjanitor.ui.theme.KotlinComposeSpotifyJanitorTheme
import com.daveleron.kotlincomposespotifyjanitor.view.AlbumList

class MainActivity : ComponentActivity() {

    private var getListAlbums: MutableList<AlbumItems> by mutableStateOf(mutableListOf())
    private var isLoading: Boolean by mutableStateOf(false)
    private val albumViewModel by viewModels<AlbumViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComposeSpotifyJanitorTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainActivityLayout(getAlbumsList = getListAlbums, isLoading = isLoading)
                }
            }
        }
        albumViewModel.getAlbumData().observe(this, Observer { it ->
            it.let { spotifyApiResponse ->
                when (spotifyApiResponse.myApiStatus) {
                    SpotifyApiStatus.SUCCESS -> {
                        spotifyApiResponse.data?.let { it ->
                            getListAlbums.clear()
                            getListAlbums.addAll(it.albumItems.reversed())
                            isLoading = false
                        }
                    }
                    SpotifyApiStatus.ERROR -> {
                        isLoading = false
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    SpotifyApiStatus.LOADING -> {
                        isLoading = true
                    }
                }
            }
        })
    }
}

@Composable
fun MainActivityLayout(getAlbumsList : MutableList<AlbumItems>, isLoading: Boolean) {
    if(isLoading){
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator()
        }
    } else {
        AlbumList(listAlbums = getAlbumsList)
    }
}