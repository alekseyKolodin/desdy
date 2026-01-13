# Desdy Design System

Современная дизайн-система для Android-приложений на Jetpack Compose.

## Содержание

1. [Установка](#установка)
2. [Быстрый старт](#быстрый-старт)
3. [Тема](#тема)
   - [DesdyTheme](#desdytheme)
   - [Доступ к токенам](#доступ-к-токенам)
   - [Светлая и тёмная тема](#светлая-и-тёмная-тема)
4. [Foundation (Основа)](#foundation-основа)
   - [Цвета](#цвета)
   - [Типографика](#типографика)
   - [Формы](#формы)
   - [Отступы](#отступы)
   - [Высоты](#высоты)
5. [Компоненты](#компоненты)
   - [Кнопки](#кнопки)
   - [Текст](#текст)
   - [Текстовые поля](#текстовые-поля)
   - [Чекбоксы, радио-кнопки, переключатели](#чекбоксы-радио-кнопки-переключатели)
   - [Карточки](#карточки)
   - [Чипы](#чипы)
   - [Слайдеры](#слайдеры)
   - [Прогресс-индикаторы](#прогресс-индикаторы)
   - [Разделители](#разделители)
   - [Диалоги](#диалоги)
   - [Bottom Sheet](#bottom-sheet)
   - [Snackbar](#snackbar)
   - [Навигация](#навигация)
   - [Табы](#табы)
   - [Списки](#списки)
6. [Кастомизация](#кастомизация)
7. [Showcase-приложение](#showcase-приложение)

---

## Установка

### Локальная зависимость

Добавьте модуль `desdy` в ваш проект и укажите зависимость в `build.gradle.kts`:

```kotlin
dependencies {
    implementation(project(":desdy"))
}
```

### Maven (после публикации)

```kotlin
dependencies {
    implementation("com.desdy:desdy:1.0.0")
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
      implementation("com.github.YOUR_USERNAME:desdy:1.0.0")
  }
```

### Требования

- **minSdk:** 24
- **compileSdk:** 36
- **Kotlin:** 2.0+
- **Jetpack Compose BOM:** 2024.12.01+

---

## Быстрый старт

```kotlin
import com.desdy.theme.DesdyTheme
import com.desdy.components.button.DesdyButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DesdyTheme {
                DesdyButton(
                    text = "Hello Desdy",
                    onClick = { /* действие */ }
                )
            }
        }
    }
}
```

---

## Тема

### DesdyTheme

`DesdyTheme` — главный composable, оборачивающий ваше приложение и предоставляющий все дизайн-токены.

```kotlin
@Composable
fun DesdyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),  // Автоматическое определение темы
    colors: DesdyColors = if (darkTheme) DesdyDarkColors else DesdyLightColors,
    typography: DesdyTypography = DesdyTypographyDefaults,
    shapes: DesdyShapes = DesdyShapesDefaults,
    spacing: DesdySpacing = DesdySpacingDefaults,
    elevation: DesdyElevation = DesdyElevationDefaults,
    content: @Composable () -> Unit
)
```

**Пример с ручным управлением темой:**

```kotlin
var isDarkTheme by remember { mutableStateOf(false) }

DesdyTheme(darkTheme = isDarkTheme) {
    Column {
        Switch(
            checked = isDarkTheme,
            onCheckedChange = { isDarkTheme = it }
        )
        // Ваш контент
    }
}
```

### Доступ к токенам

Внутри `DesdyTheme` используйте объект `DesdyTheme` для доступа к токенам:

```kotlin
DesdyTheme {
    Text(
        text = "Заголовок",
        color = DesdyTheme.colors.primary,           // Цвет
        style = DesdyTheme.typography.headlineMedium // Типографика
    )

    Box(
        modifier = Modifier
            .padding(DesdyTheme.spacing.medium)      // Отступ 16dp
            .background(
                color = DesdyTheme.colors.surface,
                shape = DesdyTheme.shapes.medium     // Скругление 12dp
            )
    )
}
```

### Светлая и тёмная тема

Библиотека автоматически поддерживает светлую и тёмную темы:

| Токен | Светлая тема | Тёмная тема |
|-------|-------------|-------------|
| `primary` | Blue500 (#3B82F6) | Blue400 (#60A5FA) |
| `secondary` | Slate500 (#64748B) | Slate400 (#94A3B8) |
| `tertiary` | Emerald500 (#10B981) | Emerald400 (#34D399) |
| `background` | Slate50 (#F8FAFC) | Slate900 (#0F172A) |
| `surface` | White (#FFFFFF) | Slate800 (#1E293B) |
| `onPrimary` | White | Blue900 |
| `onSurface` | Slate800 | Slate200 |

---

## Foundation (Основа)

### Цвета

Цветовая палитра построена на современных, чистых оттенках:

#### Основные палитры

| Палитра | Описание | Базовый цвет |
|---------|----------|--------------|
| **Blue** (Primary) | Чистый синий | #3B82F6 |
| **Slate** (Secondary) | Нейтральный серо-синий | #64748B |
| **Emerald** (Tertiary) | Яркий изумрудный| #10B981 |
| **Neutral** | Холодный серый | #64748B |

#### Семантические цвета

```kotlin
// Основные
DesdyTheme.colors.primary              // Основной акцентный цвет
DesdyTheme.colors.onPrimary            // Текст на primary
DesdyTheme.colors.primaryContainer     // Контейнер primary
DesdyTheme.colors.onPrimaryContainer   // Текст на контейнере

// Вторичные
DesdyTheme.colors.secondary
DesdyTheme.colors.secondaryContainer

// Третичные
DesdyTheme.colors.tertiary
DesdyTheme.colors.tertiaryContainer

// Поверхности
DesdyTheme.colors.background           // Фон приложения
DesdyTheme.colors.surface              // Поверхность карточек
DesdyTheme.colors.surfaceVariant       // Альтернативная поверхность
DesdyTheme.colors.surfaceContainer     // Контейнер

// Статусы
DesdyTheme.colors.error                // Ошибка (красный)
DesdyTheme.colors.success              // Успех (зелёный)
DesdyTheme.colors.warning              // Предупреждение (жёлтый)
DesdyTheme.colors.info                 // Информация (синий)

// Специальные
DesdyTheme.colors.outline              // Границы
DesdyTheme.colors.divider              // Разделители
DesdyTheme.colors.disabled             // Отключённые элементы
DesdyTheme.colors.scrim                // Затемнение фона
```

### Типографика

15 стилей текста согласно Material 3:

```kotlin
// Display — большие заголовки (hero-секции)
DesdyTheme.typography.displayLarge     // 57sp
DesdyTheme.typography.displayMedium    // 45sp
DesdyTheme.typography.displaySmall     // 36sp

// Headline — заголовки секций
DesdyTheme.typography.headlineLarge    // 32sp
DesdyTheme.typography.headlineMedium   // 28sp
DesdyTheme.typography.headlineSmall    // 24sp

// Title — заголовки карточек
DesdyTheme.typography.titleLarge       // 22sp, Medium
DesdyTheme.typography.titleMedium      // 16sp, Medium
DesdyTheme.typography.titleSmall       // 14sp, Medium

// Body — основной текст
DesdyTheme.typography.bodyLarge        // 16sp
DesdyTheme.typography.bodyMedium       // 14sp (по умолчанию)
DesdyTheme.typography.bodySmall        // 12sp

// Label — кнопки, чипы, подписи
DesdyTheme.typography.labelLarge       // 14sp, Medium
DesdyTheme.typography.labelMedium      // 12sp, Medium
DesdyTheme.typography.labelSmall       // 11sp, Medium
```

**Пример:**

```kotlin
Text(
    text = "Заголовок раздела",
    style = DesdyTheme.typography.headlineMedium,
    color = DesdyTheme.colors.onSurface
)
```

### Формы

7 вариантов скругления углов:

```kotlin
DesdyTheme.shapes.none        // 0dp — острые углы
DesdyTheme.shapes.extraSmall  // 4dp — минимальное скругление
DesdyTheme.shapes.small       // 8dp — кнопки, чипы
DesdyTheme.shapes.medium      // 12dp — карточки, диалоги
DesdyTheme.shapes.large       // 16dp — bottom sheets
DesdyTheme.shapes.extraLarge  // 28dp — большие поверхности
DesdyTheme.shapes.full        // 50% — пилюли, FAB
```

**Пример:**

```kotlin
Box(
    modifier = Modifier
        .background(
            color = DesdyTheme.colors.primaryContainer,
            shape = DesdyTheme.shapes.medium
        )
)
```

### Отступы

12 значений на основе сетки 4dp:

```kotlin
DesdyTheme.spacing.none         // 0dp
DesdyTheme.spacing.hairline     // 2dp
DesdyTheme.spacing.extraSmall   // 4dp
DesdyTheme.spacing.small        // 8dp
DesdyTheme.spacing.mediumSmall  // 12dp
DesdyTheme.spacing.medium       // 16dp
DesdyTheme.spacing.mediumLarge  // 20dp
DesdyTheme.spacing.large        // 24dp
DesdyTheme.spacing.extraLarge   // 32dp
DesdyTheme.spacing.huge         // 40dp
DesdyTheme.spacing.extraHuge    // 48dp
DesdyTheme.spacing.massive      // 64dp
```

**Пример:**

```kotlin
Column(
    modifier = Modifier.padding(DesdyTheme.spacing.medium),
    verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
) {
    // контент
}
```

### Высоты

6 уровней elevation согласно Material 3:

```kotlin
DesdyTheme.elevation.level0  // 0dp — плоская поверхность
DesdyTheme.elevation.level1  // 1dp — карточки
DesdyTheme.elevation.level2  // 3dp — приподнятые карточки
DesdyTheme.elevation.level3  // 6dp — навигация, FAB
DesdyTheme.elevation.level4  // 8dp — меню
DesdyTheme.elevation.level5  // 12dp — диалоги
```

---

## Компоненты

### Кнопки

#### DesdyButton (Filled)

Основная кнопка для главных действий.

```kotlin
// Простая кнопка
DesdyButton(
    text = "Отправить",
    onClick = { }
)

// С иконкой
DesdyButton(
    text = "Отправить",
    onClick = { },
    leadingIcon = Icons.Default.Send
)

// Состояние загрузки
DesdyButton(
    text = "Сохранение...",
    onClick = { },
    loading = true
)

// Отключённая
DesdyButton(
    text = "Недоступно",
    onClick = { },
    enabled = false
)

// С кастомным контентом
DesdyButton(onClick = { }) {
    Icon(Icons.Default.Add, null)
    Spacer(Modifier.width(8.dp))
    Text("Добавить")
}
```

#### DesdyTonalButton

Вторичная кнопка с меньшим акцентом.

```kotlin
DesdyTonalButton(
    text = "Подробнее",
    onClick = { }
)
```

#### DesdyOutlinedButton

Кнопка с обводкой.

```kotlin
DesdyOutlinedButton(
    text = "Отмена",
    onClick = { }
)
```

#### DesdyTextButton

Текстовая кнопка для наименее важных действий.

```kotlin
DesdyTextButton(
    text = "Пропустить",
    onClick = { }
)
```

#### Иконочные кнопки

```kotlin
// Стандартная
DesdyIconButton(
    icon = Icons.Default.Favorite,
    onClick = { },
    contentDescription = "В избранное"
)

// Заполненная
DesdyFilledIconButton(
    icon = Icons.Default.Add,
    onClick = { }
)

// Тональная
DesdyFilledTonalIconButton(
    icon = Icons.Default.Edit,
    onClick = { }
)

// С обводкой
DesdyOutlinedIconButton(
    icon = Icons.Default.Share,
    onClick = { }
)
```

### Текст

Готовые компоненты для каждого стиля типографики:

```kotlin
// Display
DisplayLarge(text = "Hero")
DisplayMedium(text = "Большой заголовок")
DisplaySmall(text = "Заголовок")

// Headline
HeadlineLarge(text = "Раздел")
HeadlineMedium(text = "Подраздел")
HeadlineSmall(text = "Группа")

// Title
TitleLarge(text = "Название карточки")
TitleMedium(text = "Заголовок списка")
TitleSmall(text = "Подзаголовок")

// Body
BodyLarge(text = "Увеличенный текст")
BodyMedium(text = "Основной текст контента")
BodySmall(text = "Дополнительная информация")

// Label
LabelLarge(text = "КНОПКА")
LabelMedium(text = "Подпись")
LabelSmall(text = "Мелкий текст")
```

**С параметрами:**

```kotlin
HeadlineMedium(
    text = "Заголовок",
    color = DesdyTheme.colors.primary,
    textAlign = TextAlign.Center,
    maxLines = 2,
    modifier = Modifier.fillMaxWidth()
)
```

**Базовый компонент:**

```kotlin
DesdyText(
    text = "Любой текст",
    style = DesdyTheme.typography.bodyMedium,
    color = DesdyTheme.colors.onSurface,
    textDecoration = TextDecoration.Underline
)
```

### Текстовые поля

#### DesdyTextField (Filled)

```kotlin
var text by remember { mutableStateOf("") }

DesdyTextField(
    value = text,
    onValueChange = { text = it },
    label = "Email",
    placeholder = "Введите email",
    leadingIcon = { Icon(Icons.Default.Email, null) },
    supportingText = "Мы не будем делиться вашим email"
)
```

#### DesdyOutlinedTextField

```kotlin
DesdyOutlinedTextField(
    value = text,
    onValueChange = { text = it },
    label = "Имя пользователя",
    placeholder = "Введите имя"
)
```

#### Состояние ошибки

```kotlin
DesdyOutlinedTextField(
    value = email,
    onValueChange = { email = it },
    label = "Email",
    isError = !isValidEmail(email),
    errorMessage = "Некорректный формат email"
)
```

#### DesdyPasswordField

Поле пароля с кнопкой показа/скрытия:

```kotlin
var password by remember { mutableStateOf("") }

DesdyPasswordField(
    value = password,
    onValueChange = { password = it },
    label = "Пароль"
)
```

#### DesdySearchField

Поле поиска с кнопкой очистки:

```kotlin
var query by remember { mutableStateOf("") }

DesdySearchField(
    value = query,
    onValueChange = { query = it },
    onSearch = { performSearch(it) },
    placeholder = "Поиск..."
)
```

### Чекбоксы, радио-кнопки, переключатели

#### Checkbox

```kotlin
var checked by remember { mutableStateOf(false) }

// Простой
DesdyCheckbox(
    checked = checked,
    onCheckedChange = { checked = it }
)

// С подписью
DesdyLabeledCheckbox(
    checked = checked,
    onCheckedChange = { checked = it },
    label = "Принимаю условия использования"
)

// Tri-state (для списков)
DesdyTriStateCheckbox(
    state = ToggleableState.Indeterminate,
    onClick = { }
)
```

#### RadioButton

```kotlin
var selected by remember { mutableStateOf("option1") }

// Простой
DesdyRadioButton(
    selected = selected == "option1",
    onClick = { selected = "option1" }
)

// С подписью
DesdyLabeledRadioButton(
    selected = selected == "option1",
    onClick = { selected = "option1" },
    label = "Вариант 1"
)

// Группа
DesdyRadioGroup(
    options = listOf("Маленький", "Средний", "Большой"),
    selected = selectedSize,
    onSelectedChange = { selectedSize = it }
)

// С кастомными данными
data class Size(val id: String, val name: String)

DesdyRadioGroup(
    options = listOf(Size("s", "S"), Size("m", "M"), Size("l", "L")),
    selected = selectedSize,
    onSelectedChange = { selectedSize = it },
    optionLabel = { it.name }
)
```

#### Switch

```kotlin
var enabled by remember { mutableStateOf(true) }

// Простой
DesdySwitch(
    checked = enabled,
    onCheckedChange = { enabled = it }
)

// С подписью (подпись слева, переключатель справа)
DesdyLabeledSwitch(
    checked = enabled,
    onCheckedChange = { enabled = it },
    label = "Включить уведомления"
)
```

### Карточки

#### DesdyCard (Filled)

```kotlin
DesdyCard(
    modifier = Modifier.fillMaxWidth()
) {
    Column(modifier = Modifier.padding(16.dp)) {
        TitleMedium(text = "Заголовок")
        BodyMedium(text = "Содержимое карточки")
    }
}

// Кликабельная
DesdyCard(
    onClick = { navigateToDetails() },
    modifier = Modifier.fillMaxWidth()
) {
    // контент
}
```

#### DesdyElevatedCard

Карточка с тенью:

```kotlin
DesdyElevatedCard {
    Column(modifier = Modifier.padding(16.dp)) {
        TitleMedium(text = "Приподнятая карточка")
        BodyMedium(text = "С эффектом тени")
    }
}
```

#### DesdyOutlinedCard

Карточка с обводкой:

```kotlin
DesdyOutlinedCard {
    Column(modifier = Modifier.padding(16.dp)) {
        TitleMedium(text = "Карточка с рамкой")
    }
}
```

### Чипы

#### DesdyFilterChip

Для фильтрации контента:

```kotlin
var selected by remember { mutableStateOf(false) }

DesdyFilterChip(
    label = "Новые",
    selected = selected,
    onClick = { selected = !selected }
)
```

#### DesdyInputChip

Для тегов и выбранных значений:

```kotlin
DesdyInputChip(
    label = "Kotlin",
    selected = false,
    onClick = { },
    onRemove = { removeTag("Kotlin") }  // Показывает кнопку удаления
)
```

#### DesdyAssistChip

Для умных действий:

```kotlin
DesdyAssistChip(
    label = "Добавить в избранное",
    onClick = { },
    leadingIcon = Icons.Default.Star
)
```

#### DesdySuggestionChip

Для подсказок:

```kotlin
DesdySuggestionChip(
    label = "Jetpack Compose",
    onClick = { applyFilter("compose") }
)
```

### Слайдеры

#### DesdySlider

```kotlin
var value by remember { mutableFloatStateOf(0.5f) }

DesdySlider(
    value = value,
    onValueChange = { value = it },
    valueRange = 0f..1f
)

// С шагами
DesdySlider(
    value = value,
    onValueChange = { value = it },
    valueRange = 0f..100f,
    steps = 9  // 10 позиций (0, 10, 20, ..., 100)
)
```

#### DesdyLabeledSlider

С подписью и отображением значения:

```kotlin
var volume by remember { mutableFloatStateOf(50f) }

DesdyLabeledSlider(
    value = volume,
    onValueChange = { volume = it },
    label = "Громкость",
    valueLabel = { "${it.toInt()}%" },
    valueRange = 0f..100f
)
```

#### DesdyRangeSlider

Для выбора диапазона:

```kotlin
var range by remember { mutableStateOf(20f..80f) }

DesdyRangeSlider(
    value = range,
    onValueChange = { range = it },
    valueRange = 0f..100f
)
```

### Прогресс-индикаторы

#### Линейный

```kotlin
// Определённый прогресс
DesdyLinearProgressIndicator(
    progress = { 0.7f },  // 70%
    modifier = Modifier.fillMaxWidth()
)

// Неопределённый (бесконечный)
DesdyLinearProgressIndicator(
    modifier = Modifier.fillMaxWidth()
)
```

#### Круговой

```kotlin
// Неопределённый
DesdyCircularProgressIndicator()

// Определённый
DesdyCircularProgressIndicator(
    progress = { 0.7f }
)

// Размеры
DesdySmallCircularProgress()   // 24dp
DesdyMediumCircularProgress()  // 40dp
DesdyLargeCircularProgress()   // 64dp
```

### Разделители

```kotlin
// Горизонтальный
DesdyDivider()

// С параметрами
DesdyDivider(
    thickness = 2.dp,
    color = DesdyTheme.colors.primary
)

// Вертикальный
DesdyVerticalDivider(
    modifier = Modifier.height(24.dp)
)
```

### Диалоги

#### DesdyAlertDialog

```kotlin
var showDialog by remember { mutableStateOf(false) }

if (showDialog) {
    DesdyAlertDialog(
        onDismissRequest = { showDialog = false },
        title = "Внимание",
        text = "Вы уверены, что хотите продолжить?",
        icon = Icons.Default.Warning,
        confirmButton = {
            DesdyButton(
                text = "OK",
                onClick = { showDialog = false }
            )
        },
        dismissButton = {
            DesdyTextButton(
                text = "Отмена",
                onClick = { showDialog = false }
            )
        }
    )
}
```

#### DesdyConfirmDialog

Упрощённый диалог подтверждения:

```kotlin
DesdyConfirmDialog(
    visible = showConfirm,
    onConfirm = { saveChanges() },
    onDismiss = { showConfirm = false },
    title = "Сохранить изменения?",
    message = "Все несохранённые данные будут потеряны.",
    confirmText = "Сохранить",
    dismissText = "Отмена"
)
```

#### DesdyDestructiveDialog

Для опасных действий (удаление):

```kotlin
DesdyDestructiveDialog(
    visible = showDelete,
    onConfirm = { deleteItem() },
    onDismiss = { showDelete = false },
    title = "Удалить элемент?",
    message = "Это действие нельзя отменить.",
    confirmText = "Удалить",
    dismissText = "Отмена",
    icon = Icons.Default.Delete
)
```

### Bottom Sheet

```kotlin
var showSheet by remember { mutableStateOf(false) }
val sheetState = rememberModalBottomSheetState()

if (showSheet) {
    DesdyModalBottomSheet(
        onDismissRequest = { showSheet = false },
        sheetState = sheetState
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            TitleMedium(text = "Выберите действие")
            Spacer(Modifier.height(16.dp))

            DesdyClickableListItem(
                headlineContent = { Text("Редактировать") },
                leadingContent = { Icon(Icons.Default.Edit, null) },
                onClick = { }
            )
            DesdyClickableListItem(
                headlineContent = { Text("Удалить") },
                leadingContent = { Icon(Icons.Default.Delete, null) },
                onClick = { }
            )
        }
    }
}
```

### Snackbar

```kotlin
val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()

Scaffold(
    snackbarHost = {
        DesdySnackbarHost(hostState = snackbarHostState)
    }
) { padding ->
    DesdyButton(
        text = "Показать Snackbar",
        onClick = {
            scope.launch {
                snackbarHostState.showSnackbar(
                    message = "Операция выполнена",
                    actionLabel = "Отменить",
                    duration = SnackbarDuration.Short
                )
            }
        }
    )
}
```

### Навигация

#### DesdyTopAppBar

```kotlin
Scaffold(
    topBar = {
        DesdyTopAppBar(
            title = { Text("Главная") },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Menu, "Меню")
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.Search, "Поиск")
                }
            }
        )
    }
) { padding ->
    // контент
}
```

#### DesdyCenterAlignedTopAppBar

```kotlin
DesdyCenterAlignedTopAppBar(
    title = { Text("Профиль") },
    navigationIcon = {
        IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, "Назад")
        }
    }
)
```

#### DesdyLargeTopAppBar

Сворачиваемый при скролле:

```kotlin
val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
        DesdyLargeTopAppBar(
            title = { Text("Настройки") },
            scrollBehavior = scrollBehavior
        )
    }
) { padding ->
    LazyColumn(modifier = Modifier.padding(padding)) {
        // контент
    }
}
```

#### DesdyNavigationBar (Bottom Navigation)

```kotlin
var selectedTab by remember { mutableIntStateOf(0) }

Scaffold(
    bottomBar = {
        DesdyNavigationBar {
            DesdyNavigationBarItem(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                icon = { Icon(Icons.Default.Home, null) },
                label = { Text("Главная") }
            )
            DesdyNavigationBarItem(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                icon = { Icon(Icons.Default.Search, null) },
                label = { Text("Поиск") }
            )
            DesdyNavigationBarItem(
                selected = selectedTab == 2,
                onClick = { selectedTab = 2 },
                icon = { Icon(Icons.Default.Person, null) },
                label = { Text("Профиль") }
            )
        }
    }
) { padding ->
    // контент
}
```

### Табы

```kotlin
var selectedTab by remember { mutableIntStateOf(0) }
val tabs = listOf("Все", "Активные", "Завершённые")

Column {
    DesdyTabRow(selectedTabIndex = selectedTab) {
        tabs.forEachIndexed { index, title ->
            DesdyTab(
                selected = selectedTab == index,
                onClick = { selectedTab = index },
                text = { Text(title) }
            )
        }
    }

    // Контент вкладки
    when (selectedTab) {
        0 -> AllItems()
        1 -> ActiveItems()
        2 -> CompletedItems()
    }
}
```

**Прокручиваемые табы:**

```kotlin
DesdyScrollableTabRow(selectedTabIndex = selectedTab) {
    categories.forEachIndexed { index, category ->
        DesdyTab(
            selected = selectedTab == index,
            onClick = { selectedTab = index },
            text = { Text(category.name) },
            icon = { Icon(category.icon, null) }
        )
    }
}
```

### Списки

```kotlin
// Простой элемент
DesdyListItem(
    headlineContent = { Text("Заголовок") }
)

// Полный вариант
DesdyListItem(
    headlineContent = { Text("Название файла") },
    supportingContent = { Text("Размер: 2.5 MB") },
    overlineContent = { Text("Документ") },
    leadingContent = {
        Icon(Icons.Default.Description, null)
    },
    trailingContent = {
        Icon(Icons.Default.MoreVert, null)
    }
)

// Кликабельный
DesdyClickableListItem(
    headlineContent = { Text("Настройки") },
    supportingContent = { Text("Общие настройки приложения") },
    leadingContent = { Icon(Icons.Default.Settings, null) },
    onClick = { openSettings() }
)
```

---

## Кастомизация

### Создание собственной цветовой схемы

```kotlin
val MyCustomColors = DesdyColors(
    primary = Color(0xFF6200EE),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFBB86FC),
    onPrimaryContainer = Color.Black,
    // ... остальные цвета
)

DesdyTheme(colors = MyCustomColors) {
    // ваш контент
}
```

### Кастомная типографика

```kotlin
val MyTypography = DesdyTypographyDefaults.copy(
    headlineMedium = DesdyTypographyDefaults.headlineMedium.copy(
        fontFamily = FontFamily(Font(R.font.my_custom_font)),
        fontWeight = FontWeight.Bold
    )
)

DesdyTheme(typography = MyTypography) {
    // ваш контент
}
```

### Кастомные формы

```kotlin
val MyShapes = DesdyShapesDefaults.copy(
    medium = RoundedCornerShape(16.dp),  // Более скруглённые карточки
    small = RoundedCornerShape(12.dp)     // Более скруглённые кнопки
)

DesdyTheme(shapes = MyShapes) {
    // ваш контент
}
```

### Кастомные отступы

```kotlin
val CompactSpacing = DesdySpacingDefaults.copy(
    medium = 12.dp,  // Меньше стандартного
    large = 20.dp
)

DesdyTheme(spacing = CompactSpacing) {
    // ваш контент с уменьшенными отступами
}
```

---

## Совместимость с Material 3

Desdy построен поверх Material 3 и полностью совместим с его компонентами. Все токены автоматически конвертируются:

```kotlin
DesdyTheme {
    // Работают оба варианта:

    // Desdy компоненты
    DesdyButton(text = "Desdy", onClick = { })

    // Material 3 компоненты (используют те же цвета)
    Button(onClick = { }) { Text("Material 3") }
}
```

---

## Showcase-приложение

В модуле `app` находится полноценное showcase-приложение, демонстрирующее все возможности дизайн-системы.

### Структура приложения

Приложение использует Bottom Navigation с 4 экранами:

| Экран | Описание |
|-------|----------|
| **Компоненты** | Все UI-компоненты в раскрывающихся секциях (кнопки, поля ввода, чипы, карточки и др.) |
| **Фундамент** | Дизайн-токены: цвета, типографика, формы, отступы |
| **Примеры** | Реалистичные UI-примеры: чат, карточка товара, форма логина, настройки |
| **Настройки** | Переключение темы и информация о системе |

### Запуск

```bash
./gradlew :app:installDebug
```

### Скриншоты

Showcase-приложение демонстрирует:

- **Чат** — интерфейс в стиле Telegram с пузырями сообщений
- **Карточка товара** — список товаров в стиле Samokat со скидками
- **Форма логина** — авторизация с валидацией
- **Настройки** — типичный экран настроек с переключателями

---

## Лицензия

MIT License
