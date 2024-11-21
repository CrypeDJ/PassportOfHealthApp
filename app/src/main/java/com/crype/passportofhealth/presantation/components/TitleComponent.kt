package com.crype.passportofhealth.presantation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun TitleComponent(
    text: String,
    size: TextUnit
) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = size,
        modifier = Modifier
            .padding(vertical = 5.dp),
    )
}