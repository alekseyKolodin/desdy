package com.desdy.components.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.desdy.theme.DesdyTheme

/**
 * Desdy filled text field.
 *
 * @param value Current text value.
 * @param onValueChange Called when text changes.
 * @param modifier Modifier for the text field.
 * @param enabled Whether the text field is enabled.
 * @param readOnly Whether the text field is read-only.
 * @param label Label text.
 * @param placeholder Placeholder text.
 * @param leadingIcon Optional leading icon.
 * @param trailingIcon Optional trailing icon.
 * @param supportingText Supporting/helper text below the field.
 * @param isError Whether the field is in error state.
 * @param errorMessage Error message to display.
 * @param visualTransformation Visual transformation (e.g., password masking).
 * @param keyboardOptions Keyboard options.
 * @param keyboardActions Keyboard actions.
 * @param singleLine Whether the field is single line.
 * @param maxLines Maximum number of lines.
 */
@Composable
fun DesdyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: String? = null,
    isError: Boolean = false,
    errorMessage: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE
) {
    Column(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            readOnly = readOnly,
            label = label?.let { { Text(it) } },
            placeholder = placeholder?.let { { Text(it) } },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            supportingText = if (isError && errorMessage != null) {
                { Text(errorMessage) }
            } else supportingText?.let {
                { Text(it) }
            },
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            shape = DesdyTheme.shapes.small,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = DesdyTheme.colors.surfaceVariant,
                unfocusedContainerColor = DesdyTheme.colors.surfaceVariant,
                disabledContainerColor = DesdyTheme.colors.surfaceVariant.copy(alpha = 0.5f),
                errorContainerColor = DesdyTheme.colors.errorContainer.copy(alpha = 0.3f),
                focusedIndicatorColor = DesdyTheme.colors.primary,
                unfocusedIndicatorColor = DesdyTheme.colors.outline,
                disabledIndicatorColor = DesdyTheme.colors.disabled,
                errorIndicatorColor = DesdyTheme.colors.error,
                focusedLabelColor = DesdyTheme.colors.primary,
                unfocusedLabelColor = DesdyTheme.colors.onSurfaceVariant,
                disabledLabelColor = DesdyTheme.colors.onDisabled,
                errorLabelColor = DesdyTheme.colors.error,
                cursorColor = DesdyTheme.colors.primary,
                errorCursorColor = DesdyTheme.colors.error
            )
        )
    }
}

/**
 * Desdy outlined text field.
 */
@Composable
fun DesdyOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: String? = null,
    isError: Boolean = false,
    errorMessage: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            readOnly = readOnly,
            label = label?.let { { Text(it) } },
            placeholder = placeholder?.let { { Text(it) } },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            supportingText = if (isError && errorMessage != null) {
                { Text(errorMessage) }
            } else supportingText?.let {
                { Text(it) }
            },
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            shape = DesdyTheme.shapes.small,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = DesdyTheme.colors.primary,
                unfocusedBorderColor = DesdyTheme.colors.outline,
                disabledBorderColor = DesdyTheme.colors.disabled,
                errorBorderColor = DesdyTheme.colors.error,
                focusedLabelColor = DesdyTheme.colors.primary,
                unfocusedLabelColor = DesdyTheme.colors.onSurfaceVariant,
                disabledLabelColor = DesdyTheme.colors.onDisabled,
                errorLabelColor = DesdyTheme.colors.error,
                cursorColor = DesdyTheme.colors.primary,
                errorCursorColor = DesdyTheme.colors.error
            )
        )
    }
}

/**
 * Desdy password field.
 *
 * Text field with password masking and visibility toggle.
 */
@Composable
fun DesdyPasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String? = "Password",
    placeholder: String? = null,
    isError: Boolean = false,
    errorMessage: String? = null,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    var passwordVisible by remember { mutableStateOf(false) }

    DesdyOutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        label = label,
        placeholder = placeholder,
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    imageVector = if (passwordVisible) {
                        Icons.Default.VisibilityOff
                    } else {
                        Icons.Default.Visibility
                    },
                    contentDescription = if (passwordVisible) "Hide password" else "Show password"
                )
            }
        },
        isError = isError,
        errorMessage = errorMessage,
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        keyboardActions = keyboardActions
    )
}

/**
 * Desdy search field.
 *
 * Text field optimized for search input.
 */
@Composable
fun DesdySearchField(
    value: String,
    onValueChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: String = "Search..."
) {
    DesdyOutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        placeholder = placeholder,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = DesdyTheme.colors.onSurfaceVariant
            )
        },
        trailingIcon = if (value.isNotEmpty()) {
            {
                IconButton(onClick = { onValueChange("") }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear",
                        tint = DesdyTheme.colors.onSurfaceVariant
                    )
                }
            }
        } else null,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { onSearch(value) })
    )
}

@Preview(showBackground = true)
@Composable
private fun DesdyTextFieldPreview() {
    DesdyTheme {
        DesdyTextField(
            value = "",
            onValueChange = { },
            label = "Email",
            placeholder = "Enter your email",
            modifier = Modifier.padding(DesdyTheme.spacing.medium)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DesdyOutlinedTextFieldPreview() {
    DesdyTheme {
        DesdyOutlinedTextField(
            value = "",
            onValueChange = { },
            label = "Email",
            placeholder = "Enter your email",
            modifier = Modifier.padding(DesdyTheme.spacing.medium)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DesdyTextFieldErrorPreview() {
    DesdyTheme {
        DesdyOutlinedTextField(
            value = "invalid",
            onValueChange = { },
            label = "Email",
            isError = true,
            errorMessage = "Invalid email format",
            modifier = Modifier.padding(DesdyTheme.spacing.medium)
        )
    }
}
