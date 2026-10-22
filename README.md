# Valorant-Agents

[![Android CI](https://github.com/polataydinn/Valorant-Agents/actions/workflows/android.yml/badge.svg)](https://github.com/polataydinn/Valorant-Agents/actions/workflows/android.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-red.svg)](LICENSE)

<p align="center">
Valorant Agents is a small demo application with MVVM architecture in accordance with the concept of separation of concerns.
It lists every playable Valorant agent from <a href="https://valorant-api.com">valorant-api.com</a> and shows each agent's biography and abilities.
</p>

<p align="center">
<img src="https://user-images.githubusercontent.com/45331624/157401662-38267b85-feaa-4451-bcc9-f3360e66f088.png"/>
</p>

## Tech Stack & Open-Source Library
- Kotlin 2.3
- Coroutines & Flow
- Use Case
- SavedStateHandle
- Dependency Injection (Dagger - Hilt with KSP)
- [Splash Api](https://developer.android.com/guide/topics/ui/splash-screen)
- [Retrofit & OkHttp](https://github.com/square/retrofit) - construct the REST APIs network data.
- [Glide](https://github.com/bumptech/glide)
- Jetpack
  - Lifecycle - dispose of observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - Navigation Component with Safe Args
  - Palette - card colors generated from each agent portrait
- Architecture
  - MVVM Architecture
  - Repository pattern
  - Domain models separated from network DTOs

## Project Structure
```
app/src/main/java/com/example/valorantagents
├── common          # Resource wrapper and constants
├── data            # Retrofit API, DTOs and repository implementation
├── di              # Hilt modules
├── domain          # Models, repository contract and use cases
└── presentation    # Activity, fragments, view models and adapters
```

## Building
Requirements: Android Studio (latest stable) or JDK 21+ with the Android SDK (API 36).

```bash
./gradlew assembleDebug        # build the debug APK
./gradlew testDebugUnitTest    # run unit tests
```

Every push and pull request is built and tested on GitHub Actions.

## Contributing
Issues and pull requests are welcome. Please make sure `./gradlew testDebugUnitTest` passes before opening a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
