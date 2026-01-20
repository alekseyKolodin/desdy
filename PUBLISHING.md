# Публикация Desdy на JitPack

## Быстрая публикация

```bash
# 1. Закоммитить изменения
git add .
git commit -m "v2.0.2: Описание изменений"

# 2. Создать тег
git tag v2.0.2

# 3. Запушить
git push origin main
git push origin v2.0.2
```

---

## Подробная инструкция

### 1. Проверить сборку локально

Перед публикацией убедитесь, что проект компилируется:

```bash
./gradlew :shared:build
```

### 2. Обновить версию

Отредактируйте версию в `shared/build.gradle.kts`:

```kotlin
publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.alekseyKolodin"
            artifactId = "desdy"
            version = "2.0.2"  // <- Обновить здесь
            // ...
        }
    }
}
```

### 3. Закоммитить изменения

```bash
git add .
git commit -m "v2.0.2: Краткое описание изменений

- Пункт 1
- Пункт 2
- Пункт 3"
```

### 4. Создать тег версии

```bash
git tag v2.0.2
```

### 5. Запушить на GitHub

```bash
git push origin main
git push origin v2.0.2
```

### 6. Проверить сборку на JitPack

1. Перейти на https://jitpack.io/#alekseyKolodin/desdy
2. Найти свой тег в списке
3. Нажать "Get it" для запуска сборки
4. Дождаться зелёной галочки ✓

---

## Использование в проектах

### Gradle (Kotlin DSL)

**settings.gradle.kts:**
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

**build.gradle.kts:**
```kotlin
dependencies {
    // Kotlin Multiplatform (Android, iOS, Desktop)
    implementation("com.github.alekseyKolodin.desdy:shared:2.0.2")
}
```

### Gradle (Groovy)

**settings.gradle:**
```groovy
dependencyResolutionManagement {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

**build.gradle:**
```groovy
dependencies {
    implementation 'com.github.alekseyKolodin.desdy:shared:2.0.2'
}
```

---

## Структура артефактов

После публикации доступны следующие артефакты:

| Платформа | Артефакт |
|-----------|----------|
| Android | `desdy-android` |
| Desktop (JVM) | `desdy-desktop` |
| iOS | Framework `DesdyDesign` |

---

## Удаление тега (если нужно перевыпустить)

```bash
# Удалить локально
git tag -d v2.0.2

# Удалить на remote
git push origin :refs/tags/v2.0.2
```

После этого можно создать тег заново.

---

## Troubleshooting

### Сборка на JitPack падает

1. Проверить логи на https://jitpack.io/#alekseyKolodin/desdy
2. Убедиться, что `jitpack.yml` актуален:
   ```yaml
   jdk:
     - openjdk21
   install:
     - ./gradlew :shared:publishToMavenLocal
   ```

### Зависимость не находится

1. Подождать 5-10 минут после публикации
2. Очистить кэш Gradle: `./gradlew --refresh-dependencies`
3. Проверить правильность написания версии

---

## История версий

| Версия | Дата | Описание |
|--------|------|----------|
| 2.0.2 | 2026-01 | Исправлена публикация KMP + iOS fix |
| 2.0.0 | 2026-01 | KMP миграция + SoulSync компоненты |
| 1.x.x | ... | Предыдущие версии |
