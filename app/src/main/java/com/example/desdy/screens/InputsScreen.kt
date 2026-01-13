package com.example.desdy.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.desdy.components.input.*
import com.desdy.components.navigation.DesdyTopAppBar
import com.desdy.components.text.HeadlineSmall
import com.desdy.components.text.BodySmall
import com.desdy.theme.DesdyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputsScreen(onBack: () -> Unit) {
    var textValue by remember { mutableStateOf("") }
    var outlinedValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var searchValue by remember { mutableStateOf("") }
    var errorValue by remember { mutableStateOf("invalid@") }

    Scaffold(
        topBar = {
            DesdyTopAppBar(
                title = { Text("Text Inputs") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(DesdyTheme.spacing.medium),
            verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.large)
        ) {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Filled TextField")
                    BodySmall(text = "Standard filled text input", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyTextField(
                        value = textValue,
                        onValueChange = { textValue = it },
                        label = "Email",
                        placeholder = "Enter your email",
                        leadingIcon = {
                            Icon(Icons.Default.Email, contentDescription = null)
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Outlined TextField")
                    BodySmall(text = "Text input with outline border", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyOutlinedTextField(
                        value = outlinedValue,
                        onValueChange = { outlinedValue = it },
                        label = "Username",
                        placeholder = "Enter username",
                        supportingText = "Must be at least 3 characters",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Password Field")
                    BodySmall(text = "Secure password input with visibility toggle", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyPasswordField(
                        value = passwordValue,
                        onValueChange = { passwordValue = it },
                        label = "Password",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Search Field")
                    BodySmall(text = "Optimized for search input", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdySearchField(
                        value = searchValue,
                        onValueChange = { searchValue = it },
                        onSearch = { },
                        placeholder = "Search components...",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Error State")
                    BodySmall(text = "Text field with validation error", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyOutlinedTextField(
                        value = errorValue,
                        onValueChange = { errorValue = it },
                        label = "Email",
                        isError = true,
                        errorMessage = "Please enter a valid email address",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.small)) {
                    HeadlineSmall(text = "Disabled State")
                    BodySmall(text = "Non-interactive text field", color = DesdyTheme.colors.onSurfaceVariant)
                    DesdyOutlinedTextField(
                        value = "Disabled input",
                        onValueChange = { },
                        label = "Disabled",
                        enabled = false,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
