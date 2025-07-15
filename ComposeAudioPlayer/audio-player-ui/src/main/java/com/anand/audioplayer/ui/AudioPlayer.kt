package com.anand.audioplayer.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anand.audioplayer.core.model.AudioItem
import com.anand.audioplayer.core.player.AudioPlayerManager

@Composable
fun AudioPlayer(
    audioItem: AudioItem,
    playerManager: AudioPlayerManager,
    modifier: Modifier = Modifier
) {
    var isPlaying by remember { mutableStateOf(false) }

    LaunchedEffect(audioItem.uri) {
        playerManager.prepareAndPlay(audioItem.uri)
        isPlaying = true
    }

    Column(modifier.padding(16.dp)) {
        Text(audioItem.title, style = MaterialTheme.typography.titleLarge)
        Text(audioItem.artist, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (isPlaying) {
                    playerManager.pause()
                } else {
                    playerManager.play()
                }
                isPlaying = !isPlaying
            }
        ) {
            Text(if (isPlaying) "Pause" else "Play")
        }
    }
}
