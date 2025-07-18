package com.anand.audioplayer.core.player

import android.content.Context
import android.util.Log
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer

class AudioPlayerManager(private val context: Context) {
    val player: ExoPlayer by lazy {
        ExoPlayer.Builder(context).build().apply {
            addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(state: Int) {
                    when (state) {
                        Player.STATE_BUFFERING -> Log.d("AudioPlayer", "Buffering...")
                        Player.STATE_READY -> Log.d("AudioPlayer", "Playback ready!")
                        Player.STATE_ENDED -> Log.d("AudioPlayer", "Playback ended.")
                        Player.STATE_IDLE -> Log.d("AudioPlayer", "Idle.")
                    }
                }

                override fun onPlayerError(error: PlaybackException) {
                    Log.e("AudioPlayer", "Playback error: ${error.message}")
                }
            })
        }
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
