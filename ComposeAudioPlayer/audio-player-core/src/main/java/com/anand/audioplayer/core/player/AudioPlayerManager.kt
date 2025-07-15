package com.anand.audioplayer.core.player

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class AudioPlayerManager(private val context: Context) {
    val player: ExoPlayer by lazy {
        ExoPlayer.Builder(context).build()
    }

    fun prepareAndPlay(uri: String) {
        val mediaItem = MediaItem.fromUri(uri)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }

    fun play() {
        player.play()
    }

    fun pause() {
        player.pause()
    }

    fun release() {
        player.release()
    }
}
