# 🎶 TuneBox

**TuneBox** is a sample Android app built with **Clean Architecture**, **Jetpack Compose**, **Koin** for dependency injection, and **Jetpack Media3** for media playback.  
It demonstrates playing **Nasheed** audio from raw resources while showcasing the use of **singly and doubly linked lists** for managing playback order.

---

## ✨ Features
- 🎵 Play Nasheed tracks from `res/raw`
- ⏯️ Play / Pause, Next / Previous navigation
- 📱 Jetpack Compose UI
- 🧑‍💻 Clean Architecture (Domain / Data / Presentation layers)
- ⚡ Dependency Injection with Koin
- 🎶 Background playback with Media3 `MediaController` + `MediaSession`
- 🔗 Example use cases of **Singly Linked List** and **Doubly Linked List** for audio navigation

---

## 🏗️ Architecture

The app follows **Clean Architecture** with separation of concerns:

- **Domain Layer** → Business logic & use cases (`GetAudiosUseCase`)
- **Data Layer** → Audio source definitions (raw resources wrapped in `AudioFile`)
- **Presentation Layer** → Jetpack Compose UI + ViewModels
- **DI Layer** → Koin modules for injecting use cases, ViewModels, and Media components

---
## 🔗 Linked List Use Cases
- **Singly Linked List** → Represents a sequence of Nasheed tracks where each track points to the `next` track.  
- **Doubly Linked List** → Extends navigation with both `previous` and `next`, enabling smooth `Next` / `Previous` playback.

Example:

```kotlin
data class AudioFile(
    val title: String,
    val recitedBy: String,
    @RawRes val file: Int,
    val thumbnail: String,
    var previous: AudioFile? = null,
    var next: AudioFile? = null
)
```

## 🛠️ Tech Stack
- [Kotlin](https://kotlinlang.org/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Media3](https://developer.android.com/guide/topics/media/media3)
- [Koin](https://insert-koin.io/)
- [Clean Architecture](https://8thlight.com/insights/clean-architecture)
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [Coil](https://coil-kt.github.io/coil/compose/)

---

## 🚀 Getting Started

Clone the repository:
```bash
git clone https://github.com/your-username/TuneBox.git
```
## 🔗 What is LinkedList

This project demonstrates **Linked List** concepts with practical use cases in `TuneBox`.

### 1️⃣ Singly Linked List
A **Singly Linked List** is a linear data structure where each node contains:
- **Data** (value)
- **Next pointer** (reference to the next node)

It allows **sequential traversal** in one direction only (forward).

**Use Case in TuneBox:**  
- Managing a **queue of nasheeds** where you can see favourites list.

### 2️⃣ Doubly Linked List
A **Doubly Linked List** is a linear data structure where each node contains:
- **Data** (value)
- **Next pointer** (reference to the next node)
- **Previous pointer** (reference to the previous node)

It allows traversal in **both directions** (forward and backward).

**Use Case in TuneBox:**  
- Implementing the **player playlist navigation**, where users can go **to the next or previous nasheed**.

