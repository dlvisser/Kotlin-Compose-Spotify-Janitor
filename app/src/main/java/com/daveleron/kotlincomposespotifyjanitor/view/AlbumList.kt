package com.daveleron.kotlincomposespotifyjanitor.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.daveleron.kotlincomposespotifyjanitor.model.AlbumItems

@Composable
fun AlbumList(listAlbums: MutableList<AlbumItems>){

    LazyColumn(){
        items(
            items = listAlbums,
            itemContent = { AlbumRowItem(album = it.album) }
        )
    }

}