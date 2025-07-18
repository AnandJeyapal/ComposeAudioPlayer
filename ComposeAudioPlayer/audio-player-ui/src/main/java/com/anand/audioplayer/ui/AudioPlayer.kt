package com.anand.audioplayer.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.media3.common.Player
import com.anand.audioplayer.core.model.AudioItem
import com.anand.audioplayer.core.player.AudioPlayerManager
import kotlinx.coroutines.delay
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Alignment

@Composable
fun AudioPlayer(
    audioItem: AudioItem,
    audioPlayerManager: AudioPlayerManager,
    modifier: Modifier = Modifier,
    style: AudioPlayerStyle = defaultAudioPlayerStyle()
) {
    val player = audioPlayerManager.player

    // Playback states
    var isPlaying by remember { mutableStateOf(false) }
    var isBuffering by remember { mutableStateOf(false) }
    var currentPosition by remember { mutableStateOf(0L) }
    var duration by remember { mutableStateOf(0L) }

    // Listen to playback state
    LaunchedEffect(player) {
        player.addListener(object : Player.Listener {
            override fun onIsPlayingChanged(p: Boolean) {
                isPlaying = p
            }

            override fun onPlaybackStateChanged(state: Int) {
                isBuffering = (state == Player.STATE_BUFFERING)
                duration = player.duration.coerceAtLeast(0L)
            }
        })
    }

    // Progress tracking
    LaunchedEffect(Unit) {
        while (true) {
            currentPosition = player.currentPosition
            delay(500L)
        }
    }

    // Auto play
    LaunchedEffect(Unit) {
        audioPlayerManager.prepareAndPlay(audioItem.uri)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(style.backgroundColor)
            .padding(style.padding)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text("Simple Audio Player", style = MaterialTheme.typography.titleLarge, color = style.iconTint)

            Spacer(Modifier.height(16.dp))

            // Time Row with current position and duration
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = formatTime(currentPosition), color = style.iconTint)
                Text(text = formatTime(duration), color = style.iconTint)
            }

            Slider(
                value = currentPosition.toFloat().coerceAtMost(duration.toFloat()),
                onValueChange = { player.seekTo(it.toLong()) },
                valueRange = 0f..(duration.toFloat()),
                modifier = Modifier.fillMaxWidth(),
                colors = SliderDefaults.colors(
                    thumbColor = style.primaryColor,
                    activeTrackColor = style.primaryColor
                )
            )

            Spacer(Modifier.height(16.dp))

            if (isBuffering) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(style.iconSize)
                        .align(Alignment.CenterHorizontally),
                    color = style.primaryColor
                )
            }

            Spacer(Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                IconButton(
                    onClick = { audioPlayerManager.skipBackward() },
                    enabled = duration > 0L
                ) {
                    Icon(
                        Icons.Default.Replay10,
                        contentDescription = "Rewind 10 seconds",
                        tint = style.iconTint,
                        modifier = Modifier.size(style.iconSize)
                    )
                }

                IconButton(
                    onClick = {
                        if (isPlaying) audioPlayerManager.pause()
                        else audioPlayerManager.play()
                    }
                ) {
                    Icon(
                        imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                        contentDescription = if (isPlaying) "Pause" else "Play",
                        tint = style.iconTint,
                        modifier = Modifier.size(style.iconSize)
                    )
                }

                IconButton(
                    onClick = { audioPlayerManager.skipForward() },
                    enabled = duration > 0L
                ) {
                    Icon(
                        Icons.Default.Forward10,
                        contentDescription = "Forward 10 seconds",
                        tint = style.iconTint,
                        modifier = Modifier.size(style.iconSize)
                    )
                }
            }
        }
    }
}

private fun formatTime(millis: Long): String {
    val totalSeconds = millis / 1000
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    return "%02d:%02d".format(minutes, seconds)
}
