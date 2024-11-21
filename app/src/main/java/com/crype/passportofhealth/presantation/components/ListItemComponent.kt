package com.crype.passportofhealth.presantation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.passportofhealth.presantation.ui.theme.Green
import com.crype.passportofhealth.presantation.ui.theme.LightGreen
import com.crype.passportofhealth.presantation.ui.theme.TextGrey

@Composable
fun ListItemComponent(
    mainText: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors().copy(
            containerColor = LightGreen
        ),
    ) {
        Column(
            modifier = Modifier.padding(25.dp)
        ) {
            Text(
                text = mainText,
                color = Green,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                modifier = Modifier.padding(bottom = 5.dp),
                fontFamily = FontFamily.Serif
            )
            Text(
                text = description,
                fontFamily = FontFamily.Monospace,
                fontSize = 17.sp
            )
            Text(
                text = "Подробнее>>>",
                color = TextGrey,
                fontSize = 15.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemComponentPrev() {
    ListItemComponent(mainText = "Gsdlfnsdlk", description = "15.02.2003", onClick = {})
}