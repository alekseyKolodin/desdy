package com.example.desdy.showcase.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.desdy.components.button.DesdyButton
import com.desdy.components.button.DesdyOutlinedButton
import com.desdy.components.button.DesdyTextButton
import com.desdy.components.input.DesdyOutlinedTextField
import com.desdy.components.input.DesdyPasswordField
import com.desdy.components.selection.DesdyLabeledCheckbox
import com.desdy.components.text.BodyMedium
import com.desdy.components.text.HeadlineMedium
import com.desdy.theme.DesdyTheme

/**
 * Login form example.
 */
@Composable
fun LoginExample() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(DesdyTheme.spacing.large),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo placeholder
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(DesdyTheme.colors.primary, DesdyTheme.shapes.large),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.Lock,
                contentDescription = null,
                tint = DesdyTheme.colors.onPrimary,
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(Modifier.height(DesdyTheme.spacing.extraLarge))

        HeadlineMedium(text = "Добро пожаловать")
        BodyMedium(
            text = "Войдите в свой аккаунт",
            color = DesdyTheme.colors.onSurfaceVariant
        )

        Spacer(Modifier.height(DesdyTheme.spacing.extraLarge))

        DesdyOutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            placeholder = "example@mail.com",
            leadingIcon = { Icon(Icons.Default.Email, null) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(DesdyTheme.spacing.medium))

        DesdyPasswordField(
            value = password,
            onValueChange = { password = it },
            label = "Пароль",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(DesdyTheme.spacing.small))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DesdyLabeledCheckbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it },
                label = "Запомнить меня"
            )
            DesdyTextButton(text = "Забыли пароль?", onClick = {})
        }

        Spacer(Modifier.height(DesdyTheme.spacing.large))

        DesdyButton(
            text = "Войти",
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(DesdyTheme.spacing.medium))

        DesdyOutlinedButton(
            text = "Создать аккаунт",
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}
