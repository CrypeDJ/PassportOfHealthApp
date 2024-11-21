package com.crype.passportofhealth.presantation.components.enterInfo

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "$name: ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 5.dp)
        )
        TextField(
            value = highPressure,
            onValueChange = onHighChange,
            readOnly = isEditText,
            textStyle = TextStyle().copy(
                fontSize = 20.sp
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

            )
        TextField(
            value = lowPressure,
            onValueChange = onLowChange,
            readOnly = isEditText,
            textStyle = TextStyle().copy(
                fontSize = 20.sp
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