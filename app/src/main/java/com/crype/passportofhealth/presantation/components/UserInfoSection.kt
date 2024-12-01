package com.crype.passportofhealth.presantation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserInfoSection(title: String, content: String) {
    Text(
        text = title,
        fontSize = 17.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(5.dp))
    Text(
        text = content,
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.Serif
    )
}