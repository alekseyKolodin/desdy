# Публикация Desdy

Библиотека публикуется в **GitHub Packages** через GitHub Actions.

## Публикация новой версии

### 1. Обновить версию

**shared/build.gradle.kts:**
```kotlin
version = "2.0.3"  // <- Обновить здесь
```

### 2. Закоммитить изменения

```bash
git add .
git commit -m "v2.0.3: Описание изменений"
```

### 3. Создать тег и запушить

```bash
git tag v2.0.3
git push origin main
git push origin v2.0.3
```

GitHub Actions автоматически соберёт и опубликует все артефакты (включая iOS).

### 4. Проверить публикацию

1. Перейти на https://github.com/alekseyKolodin/desdy/actions
2. Дождаться успешного завершения workflow
3. Проверить пакеты: https://github.com/alekseyKolodin/desdy/packages

---

## Использование в проектах

### 1. Создать Personal Access Token

1. GitHub → Settings → Developer settings → Personal access tokens → Tokens (classic)
2. Generate new token с правом `read:packages`
3. Сохранить токен

### 2. Настроить credentials

**~/.gradle/gradle.properties:**
```properties
gpr.user=YOUR_GITHUB_USERNAME
gpr.token=YOUR_GITHUB_TOKEN
```

### 3. Добавить репозиторий

**settings.gradle.kts:**
```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/alekseyKolodin/desdy")
            credentials {
                username = providers.gradleProperty("gpr.user").orNull ?: System.getenv("GITHUB_ACTOR")
                password = providers.gradleProperty("gpr.token").orNull ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
```

### 4. Добавить зависимость

**build.gradle.kts:**
```kotlin
dependencies {
    implementation("io.github.alekseykolodin:shared:2.0.2")
}
```

---

## Структура артефактов

После публикации доступны:

| Артефакт | Описание |
|----------|----------|
| `shared` | KMP metadata (common) |
| `shared-android` | Android |
| `shared-desktop` | Desktop (JVM) |
| `shared-iosarm64` | iOS ARM64 |
| `shared-iossimulatorarm64` | iOS Simulator ARM64 |
| `shared-iosx64` | iOS Simulator x64 |

---

## История версий

| Версия | Описание |
|--------|----------|
| 2.0.2 | GitHub Packages + iOS support |
| 2.0.0 | KMP миграция + SoulSync компоненты |
| 1.x.x | Android-only версия (JitPack) |
