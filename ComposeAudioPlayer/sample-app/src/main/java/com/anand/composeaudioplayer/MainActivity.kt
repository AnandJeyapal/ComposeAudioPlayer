package com.anand.composeaudioplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.anand.audioplayer.core.model.AudioItem
import com.anand.audioplayer.core.player.AudioPlayerManager
import com.anand.audioplayer.ui.AudioPlayer

class MainActivity : ComponentActivity() {
    private lateinit var playerManager: AudioPlayerManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        playerManager = AudioPlayerManager(this)

        setContent {
            MaterialTheme {
                AudioPlayer(
                    audioItem = AudioItem(
                        uri = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
                        title = "SoundHelix Song",
                        artist = "SoundHelix"
                    ),
                    playerManager = playerManager
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        playerManager.release()
    }
}
