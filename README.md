# Desdy Design System

Современная дизайн-система на **Kotlin Multiplatform** для Android, iOS и Desktop.

[![](https://jitpack.io/v/alekseyKolodin/desdy.svg)](https://jitpack.io/#alekseyKolodin/desdy)

## Особенности

- **Kotlin Multiplatform** — единый код для Android, iOS и Desktop
- **Compose Multiplatform** — современный UI на всех платформах
- **SoulSync темная тема** — оптимизирована для приложений отношений
- **Material 3** — полная совместимость с Material Design 3
- **Готовые компоненты** — 30+ компонентов для быстрой разработки

---

## Установка

### JitPack

**settings.gradle.kts:**
```kotlin
dependencyResolutionManagement {
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
    implementation("com.github.alekseyKolodin:desdy:2.0.0")
}
```

### From git

```
 // settings.gradle.kts
  dependencyResolutionManagement {
      repositories {
          google()
          mavenCentral()
          maven { url = uri("https://jitpack.io") }
      }
  }

  // build.gradle.kts
  dependencies {
      implementation("com.github.alekseyKolodin:desdy:1.0.0")
  }
```

### Требования

| Платформа | Минимальная версия |
|-----------|-------------------|
| Android | API 24 (Android 7.0) |
| iOS | iOS 14.0 |
| Desktop | JVM 21 |

---

## Быстрый старт

```kotlin
import com.desdy.theme.DesdyTheme
import com.desdy.components.button.DesdyButton

@Composable
fun App() {
    DesdyTheme {
        DesdyButton(
            text = "Hello Desdy",
            onClick = { /* действие */ }
        )
    }
}
```

---

## Структура проекта

```
Desdy/
├── shared/                     # KMP библиотека
│   └── src/
│       ├── commonMain/         # Общий код (95%)
│       │   └── kotlin/com/desdy/
│       │       ├── components/     # UI компоненты
│       │       ├── foundation/     # Токены дизайна
│       │       └── theme/          # Тема
│       ├── androidMain/        # Android-специфичный код
│       ├── iosMain/           # iOS-специфичный код
│       └── desktopMain/       # Desktop-специфичный код
├── android-showcase/           # Demo Android приложение
└── desktop-showcase/           # Demo Desktop приложение
```

---

## Компоненты

### Базовые компоненты

| Компонент | Описание |
|-----------|----------|
| `DesdyButton` | Кнопки (Filled, Tonal, Outlined, Text, Icon) |
| `DesdyCard` | Карточки (Filled, Elevated, Outlined) |
| `DesdyTextField` | Текстовые поля (Filled, Outlined, Password, Search) |
| `DesdyCheckbox` | Чекбокс |
| `DesdySwitch` | Переключатель |
| `DesdyRadioButton` | Радио-кнопка |
| `DesdyChip` | Чипы (Filter, Input, Assist, Suggestion) |
| `DesdySlider` | Слайдеры |
| `DesdyProgress` | Прогресс-индикаторы |
| `DesdyDialog` | Диалоги |
| `DesdyBottomSheet` | Bottom Sheet |
| `DesdySnackbar` | Snackbar |
| `DesdyNavigationBar` | Нижняя навигация |
| `DesdyTabs` | Табы |
| `DesdyListItem` | Элементы списка |

### SoulSync компоненты

Специальные компоненты для приложений отношений:

| Компонент | Описание |
|-----------|----------|
| `TemperatureGauge` | Круговой индикатор "температуры" отношений 0-100 |
| `EmojiSelector` | Горизонтальный выбор 1-10 с эмодзи |
| `MoodSelector` | Компактный выбор настроения из 5 эмодзи |
| `CheckInCard` | Карточка для вопросов чек-ина |
| `InsightCard` | Карточка AI-рекомендации |
| `StreakCounter` | Счётчик дней подряд |
| `StepProgressBar` | Пошаговый прогресс |

---

## Тема

### DesdyTheme

```kotlin
DesdyTheme(
    darkTheme = true,  // Тёмная тема по умолчанию для SoulSync
    colors = DesdyDarkColors,
    typography = DesdyTypographyDefaults,
    shapes = DesdyShapesDefaults,
    spacing = DesdySpacingDefaults
) {
    // Ваш контент
}
```

### Доступ к токенам

```kotlin
DesdyTheme {
    Text(
        text = "Заголовок",
        color = DesdyTheme.colors.primary,
        style = DesdyTheme.typography.headlineMedium
    )

    Box(
        modifier = Modifier
            .padding(DesdyTheme.spacing.medium)
            .background(
                color = DesdyTheme.colors.surface,
                shape = DesdyTheme.shapes.medium
            )
    )
}
```

### Цветовая палитра SoulSync

| Токен | Цвет | Описание |
|-------|------|----------|
| `primary` | Teal (#0284C7) | Доверие, спокойствие |
| `secondary` | Rose (#C1121F) | Страсть |
| `background` | Slate (#0F172A) | Тёмный фон |
| `surface` | Slate (#1E293B) | Поверхности |

### Температурные цвета

| Диапазон | Цвет | Описание |
|----------|------|----------|
| 0-30 | Blue | Холодно — нужна забота |
| 31-60 | Yellow | Нейтрально |
| 61-85 | Green | Тепло — отличные отношения |
| 86-100 | Red | Горячо — на пике! |

---

## Примеры использования

### Temperature Gauge

```kotlin
var temperature by remember { mutableIntStateOf(72) }

TemperatureGauge(
    temperature = temperature,
    size = 160.dp,
    showLabel = true,
    showEmoji = true
)
```

### Emoji Selector

```kotlin
var selected by remember { mutableIntStateOf(5) }

EmojiSelector(
    selectedValue = selected,
    onValueSelected = { selected = it },
    showLabels = true
)
```

### Check-In Card

```kotlin
CheckInCard(
    emoji = "💭",
    question = "Как ты себя чувствуешь сегодня?",
    hint = "Оцени своё настроение от 1 до 5"
) {
    MoodSelector(
        selectedValue = mood,
        onValueSelected = { mood = it }
    )
}
```

### Insight Card

```kotlin
InsightCard(
    emoji = "💡",
    title = "Время для свидания!",
    description = "Прошло 2 недели с вашего последнего качественного времени вместе.",
    primaryAction = "Запланировать",
    secondaryAction = "Позже",
    onPrimaryClick = { /* action */ }
)
```

### Streak Counter

```kotlin
StreakCounter(
    days = 34,
    partnerName = "Мария"
)
```

---

## Showcase приложения

### Android

```bash
./gradlew :android-showcase:installDebug
```

### Desktop

```bash
./gradlew :desktop-showcase:run
```

---

## Публикация

См. [PUBLISHING.md](PUBLISHING.md) для инструкций по публикации новых версий.

---

## История версий

| Версия | Описание |
|--------|----------|
| 2.0.0 | KMP миграция + SoulSync компоненты |
| 1.x.x | Android-only версия |

---

## Лицензия

Apache License 2.0
