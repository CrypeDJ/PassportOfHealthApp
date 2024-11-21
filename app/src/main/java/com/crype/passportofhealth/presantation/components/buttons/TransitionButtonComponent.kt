package com.crype.passportofhealth.presantation.components.buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.passportofhealth.presantation.ui.theme.TextGrey

@Composable
fun TransitionButtonComponent(
    onClick: () -> Unit,
    text: String,
    buttonText: String,
    size: TextUnit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            color = TextGrey,
            fontSize = size,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(end = 5.dp)
        )
        Text(
            text = buttonText,
            color = TextGrey,
            fontSize = size,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { onClick() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TransitionButtonComponentPreview(

) {
    TransitionButtonComponent(
        onClick = { /*TODO*/ },
        text = "Already have an account?",
        buttonText = "Sign In",
        size = 20.sp
    )
}