package com.crype.passportofhealth.presantation.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.passportofhealth.presantation.ui.theme.Green

@Composable
fun ButtonComponent(
    onClick: ()->Unit,
    text: String
){
    Button(
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = Green
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth(),
        onClick = { onClick()}) {
        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(vertical = 10.dp),
            color = Color.White,
            fontWeight = FontWeight.Light,
            fontSize = 30.sp,
        )
    }
}

@Preview
@Composable
fun ButtonComponentPreview(){
    ButtonComponent (
        text = "fsfswef",
        onClick = {}
    )
}