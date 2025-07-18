# 🎧 Jetpack Compose Audio Player

A modern, lightweight audio player built with Jetpack Compose and powered by Media3. Perfect for developers looking to stream audio in their Compose apps with minimal setup.

![Demo](demo.gif)

---

## ✨ Features

- 🔊 Stream audio from a remote URL
- 🛠️ Built using Jetpack Compose and Media3 (ExoPlayer)
- ⚡ Simple and modular architecture
- 🎨 Clean, customizable UI
- 🧪 Sample app included
- 💯 Designed for modern Android apps

---

## 🚀 Usage

```kotlin
AudioPlayer(
    audioItem = AudioItem(
        uri = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3",
        title = "Sample Song",
        artist = "SoundHelix"
    ),
    playerManager = AudioPlayerManager(context)
)
