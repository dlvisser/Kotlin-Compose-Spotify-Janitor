package com.daveleron.kotlincomposespotifyjanitor.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.daveleron.kotlincomposespotifyjanitor.R
import com.daveleron.kotlincomposespotifyjanitor.model.Album
import com.daveleron.kotlincomposespotifyjanitor.model.AlbumImage

@Composable
fun AlbumRowItem(album: Album){
    androidx.compose.material.Surface(
        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
    ) {
        Row() {
            AsyncImage(
                model = album.images[0].url,
                placeholder = painterResource(id = R.drawable.spotify_icon_rgb_black),
                contentDescription = null
            )
            Column() {
                Text(album.name)
                Text(album.uri)
            }
        }
    }
}

@Preview(widthDp = 390, heightDp = 128)
@Composable
fun AlbumRowItemPreview(){
    val list = ArrayList<AlbumImage>()
    list.add(AlbumImage(width = 640, height = 640, url = "https://i.scdn.co/image/ab67616d0000b273be82673b5f79d9658ec0a9fd"))
    AlbumRowItem(album = Album(albumType = "album", name = "MONTERO", images = list, uri = "spotify:album:6pOiDiuDQqrmo5DbG0ZubR"))
}