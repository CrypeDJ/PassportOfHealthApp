package com.crype.passportofhealth.presantation.components.enterInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.crype.passportofhealth.presantation.ui.theme.TextGrey

@Composable
fun EnterTextComponent(
    hint: String,
    visualTransformation: VisualTransformation,
    text: String,
    textChange: (String) -> Unit
){
    Column {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = textChange,
            label = {
                Text(
                    text = hint,
                    color = TextGrey,
                    fontFamily = FontFamily.Serif
                )
            },
            singleLine = true,
            visualTransformation = visualTransformation,
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )
        HorizontalDivider()
    }

}

@Preview
@Composable
fun EnterTextComponentPreview(){
    EnterTextComponent(
        hint = "sgfsdgf",
        visualTransformation = PasswordVisualTransformation(),
        text = "",
        textChange = {

        }
    )
}