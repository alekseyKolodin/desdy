package com.example.desdy.showcase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.desdy.components.divider.DesdyDivider
import com.desdy.components.selection.DesdyLabeledCheckbox
import com.desdy.components.selection.DesdyLabeledRadioButton
import com.desdy.components.selection.DesdyLabeledSwitch
import com.desdy.components.text.LabelMedium
import com.desdy.theme.DesdyTheme

/**
 * Showcase for selection controls (checkbox, radio, switch).
 */
@Composable
fun SelectionShowcase() {
    var checkbox1 by remember { mutableStateOf(false) }
    var checkbox2 by remember { mutableStateOf(true) }
    var selectedRadio by remember { mutableStateOf("option1") }
    var switch1 by remember { mutableStateOf(false) }
    var switch2 by remember { mutableStateOf(true) }

    Column(
        verticalArrangement = Arrangement.spacedBy(DesdyTheme.spacing.medium)
    ) {
        // Checkboxes
        LabelMedium(
            text = "Checkbox",
            color = DesdyTheme.colors.onSurfaceVariant
        )
        DesdyLabeledCheckbox(
            checked = checkbox1,
            onCheckedChange = { checkbox1 = it },
            label = "Unchecked option"
        )
        DesdyLabeledCheckbox(
            checked = checkbox2,
            onCheckedChange = { checkbox2 = it },
            label = "Checked option"
        )

        DesdyDivider()

        // Radio buttons
        LabelMedium(
            text = "Radio",
            color = DesdyTheme.colors.onSurfaceVariant
        )
        DesdyLabeledRadioButton(
            selected = selectedRadio == "option1",
            onClick = { selectedRadio = "option1" },
            label = "Вариант 1"
        )
        DesdyLabeledRadioButton(
            selected = selectedRadio == "option2",
            onClick = { selectedRadio = "option2" },
            label = "Вариант 2"
        )
        DesdyLabeledRadioButton(
            selected = selectedRadio == "option3",
            onClick = { selectedRadio = "option3" },
            label = "Вариант 3"
        )

        DesdyDivider()

        // Switches
        LabelMedium(
            text = "Switch",
            color = DesdyTheme.colors.onSurfaceVariant
        )
        DesdyLabeledSwitch(
            checked = switch1,
            onCheckedChange = { switch1 = it },
            label = "Уведомления"
        )
        DesdyLabeledSwitch(
            checked = switch2,
            onCheckedChange = { switch2 = it },
            label = "Тёмная тема"
        )
    }
}
