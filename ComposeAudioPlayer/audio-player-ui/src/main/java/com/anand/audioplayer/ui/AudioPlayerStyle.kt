package com.anand.audioplayer.ui

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AudioPlayerStyle(
    val backgroundColor: Color,
    val primaryColor: Color,
    val iconTint: Color,
    val iconSize: Dp = 36.dp,
    val cornerShape: CornerBasedShape = RoundedCornerShape(8.dp),
    val padding: Dp = 24.dp
)

// Composable function to get default style values from MaterialTheme
@Composable
fun defaultAudioPlayerStyle() = AudioPlayerStyle(
    backgroundColor = MaterialTheme.colorScheme.surface,
    primaryColor = MaterialTheme.colorScheme.primary,
    iconTint = MaterialTheme.colorScheme.onSurface,
    iconSize = 36.dp,
    cornerShape = RoundedCornerShape(8.dp),
    padding = 24.dp
)