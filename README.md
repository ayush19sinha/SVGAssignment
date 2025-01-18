# Dog Image Generator App

A modern Android application that generates and saves random dog images using Jetpack Compose. The app demonstrates clean architecture principles, proper state management, and modern Android development practices.

## Features

- Generate random dog images from the [Dog API](https://dog.ceo/dog-api/)
- Save recently generated images in an LRU cache
- View saved images in a image gallery
- Persistent storage between app sessions

## Tech Stack

- **UI**: Jetpack Compose
- **Architecture**: MVVM
- **Dependency Injection**: Hilt
- **Image Loading**: Coil
- **Networking**: Retrofit
- **Navigation**: Jetpack Navigation Compose
- **State Management**: Kotlin Flow
- **Persistence**: SharedPreferences
- **Concurrency**: Kotlin Coroutines

## App Demo


https://github.com/user-attachments/assets/a56eaf8f-d7e7-4c86-9059-0fe085c5f714


## Architecture

The app follows Clean Architecture principles and is organized into several key components:

- **UI Layer**: Compose screens and ViewModel
- **Data Layer**: Repository and API service
- **Cache**: Custom LRU implementation with persistence
- **DI**: Hilt modules for dependency management

## Getting Started

### Prerequisites

- Android Studio Arctic Fox or newer

### Installation

1. Clone the repository
```bash
git clone https://github.com/ayush19sinha/svgassignment.git
```

2. Open the project in Android Studio.

3. Sync project with Gradle files.

4. Run the app on an emulator or physical device.
