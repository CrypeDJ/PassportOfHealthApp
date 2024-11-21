package com.crype.passportofhealth.presantation.components.enterInfo

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
fun InfoScreenComponent(
    isEditText: Boolean,
    name: String,
    value: String,
    keyboardType: KeyboardType,
    onValueChange: () -> Unit
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
            value = value,
            onValueChange = {onValueChange()},
            readOnly = isEditText,
            textStyle = TextStyle().copy(
                fontSize = 20.sp
            ),
            keyboardOptions = KeyboardOptions().copy(
                keyboardType = keyboardType
            ),
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(15.dp)
        )
    }
}

@Preview
@Composable
fun InfoScreenPreview() {
    InfoScreenComponent(isEditText = true, name = "Дата", value = "15.04.2024", onValueChange = {}, keyboardType = KeyboardType.Text)
}