package com.anand.audioplayer.core.model

data class AudioItem(
    val uri: String,
    val title: String,
    val artist: String,
    val artworkUrl: String? = null
)
