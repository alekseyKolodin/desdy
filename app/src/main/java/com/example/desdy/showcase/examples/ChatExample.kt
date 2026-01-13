package com.example.desdy.showcase.examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.desdy.components.button.DesdyFilledIconButton
import com.desdy.components.button.DesdyIconButton
import com.desdy.components.input.DesdyTextField
import com.desdy.components.text.BodyMedium
import com.desdy.components.text.BodySmall
import com.desdy.components.text.LabelSmall
import com.desdy.components.text.TitleMedium
import com.desdy.theme.DesdyTheme

/**
 * Data class for chat messages.
 */
data class Message(
    val text: String,
    val isMe: Boolean,
    val time: String
)

/**
 * Chat example
 */
@Composable
fun ChatExample() {
    val messages = listOf(
        Message("Привет! Как дела?", isMe = false, time = "10:30"),
        Message("Привет! Отлично, работаю над новым проектом", isMe = true, time = "10:31"),
        Message("О, круто! Расскажи подробнее", isMe = false, time = "10:32"),
        Message("Делаю showcase для дизайн-системы Desdy. Там кнопки, карточки, чипы и много всего!", isMe = true, time = "10:33"),
        Message("Звучит интересно! Когда будет готово?", isMe = false, time = "10:34"),
    )
    var inputText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        // Chat header
        Surface(
            color = DesdyTheme.colors.surface,
            tonalElevation = DesdyTheme.elevation.level2
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = DesdyTheme.spacing.small, vertical = DesdyTheme.spacing.small),
                verticalAlignment = Alignment.CenterVertically
            ) {
                DesdyIconButton(
                    icon = Icons.AutoMirrored.Filled.ArrowBack,
                    onClick = {}
                )
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TitleMedium(text = "Алексей")
                    BodySmall(
                        text = "был в сети недавно",
                        color = DesdyTheme.colors.onSurfaceVariant
                    )
                }
                DesdyIconButton(icon = Icons.Default.MoreVert, onClick = {})
            }
        }

        // Messages list
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(DesdyTheme.spacing.medium),
            verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)
        ) {
            items(messages) { message ->
                ChatBubble(message)
            }
        }

        // Input bar
        Surface(
            tonalElevation = DesdyTheme.elevation.level2,
            color = DesdyTheme.colors.surface,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(DesdyTheme.spacing.small),
                verticalAlignment = Alignment.CenterVertically
            ) {
                DesdyIconButton(icon = Icons.Default.AttachFile, onClick = {})

                DesdyTextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    placeholder = "Сообщение",
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )

                DesdyFilledIconButton(
                    icon = Icons.AutoMirrored.Filled.Send,
                    onClick = {}
                )
            }
        }
    }
}

@Composable
fun ChatBubble(message: Message) {
    val alignment = if (message.isMe) Alignment.End else Alignment.Start
    val backgroundColor = if (message.isMe)
        DesdyTheme.colors.primary
    else
        DesdyTheme.colors.surfaceVariant
    val textColor = if (message.isMe)
        DesdyTheme.colors.onPrimary
    else
        DesdyTheme.colors.onSurface

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = alignment
    ) {
        Surface(
            color = backgroundColor,
            shape = RoundedCornerShape(
                topStart = 16.dp,
                topEnd = 16.dp,
                bottomStart = if (message.isMe) 16.dp else 4.dp,
                bottomEnd = if (message.isMe) 4.dp else 16.dp
            ),
            modifier = Modifier.widthIn(max = 280.dp)
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                BodyMedium(text = message.text, color = textColor)
                Spacer(Modifier.height(4.dp))
                LabelSmall(
                    text = message.time,
                    color = textColor.copy(alpha = 0.7f),
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}
