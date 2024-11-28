package com.crype.passportofhealth.presantation.components.enterInfo

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PressureComponent(
    isEditText: Boolean,
    name: String,
    highPressure: String,
    lowPressure: String,
    onHighChange: (String) -> Unit,
    onLowChange: (String) -> Unit,
) {
    var isHighEmpty by remember {
        mutableStateOf(false)
    }
    var isLowEmpty by remember {
        mutableStateOf(false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "$name: ",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 5.dp)
        )
        TextField(
            value = highPressure,
            onValueChange = {newValue ->
                if (newValue.matches(Regex("^\\d+\$"))&& newValue.length < 4) {
                    onHighChange(
                        if (isHighEmpty) newValue.dropLast(1)
                        else newValue
                    )
                    isHighEmpty = false
                } else if (newValue.isEmpty()) {
                    isHighEmpty = true
                    onHighChange("0")
                }
            },
            readOnly = !isEditText,
            textStyle = TextStyle().copy(
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            ),
            keyboardOptions = KeyboardOptions().copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.weight(1f),
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(15.dp)
        )
        Text(
            text = " / ",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(end = 5.dp)
                .weight(1f),
            textAlign = TextAlign.Center
            )
        TextField(
            value = lowPressure,
            onValueChange = {newValue ->
                if (newValue.matches(Regex("^\\d+\$"))&& newValue.length < 4) {
                    onLowChange(
                        if (isLowEmpty) newValue.dropLast(1)
                        else newValue
                    )
                    isLowEmpty = false
                } else if (newValue.isEmpty()) {
                    isLowEmpty = true
                    onLowChange("0")
                }
            },
            readOnly = !isEditText,
            textStyle = TextStyle().copy(
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            ),
            keyboardOptions = KeyboardOptions().copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.weight(1f),
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(15.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PressurePreview() {
    PressureComponent(
        isEditText = true,
        name = "Дата",
        lowPressure = "90",
        highPressure = "120",
        onHighChange = {},
        onLowChange = {})
}