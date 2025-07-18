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
```
## 📦 Gradle
To use this library in your project, add the following once publishing is complete (coming soon):

```kotlin
dependencies {
    implementation("com.github.anandjeyapal:compose-audio-player:<version>")
}
```
📌 Note: Until then, clone the repo and include audio-player-core and audio-player-ui modules in your project.

## 📱 Sample App
Run the included sample-app module to see a working example:

- Clone the repo
- Open in Android Studio
- Run sample-app on emulator/device
- Audio should start playing automatically

## 🛡 License
```swift
MIT License

Copyright (c) 2025 Anand

Permission is hereby granted, free of charge, to any person obtaining a copy...
```

## 🤝 Contributing
Pull requests, issues, and feature suggestions are welcome. Let's build this together!

## ⭐ Support the Project
If you find this library useful, please consider giving it a star 🌟 — it helps visibility and keeps the project going!
