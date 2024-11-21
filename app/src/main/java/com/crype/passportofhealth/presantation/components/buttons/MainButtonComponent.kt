package com.crype.passportofhealth.presantation.components.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.passportofhealth.R
import com.crype.passportofhealth.presantation.ui.theme.MediumGreen

@Composable
fun MainButtonComponent(
    onClick: () -> Unit,
    text: String,
    painter: Painter
) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = MediumGreen
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
    ) {
        Column {
            Icon(
                painter = painter,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .height(80.dp)
                    .width(80.dp)
            )

            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = text,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    MainButtonComponent(
        text = "Мед. история",
        onClick = {},
        painter = painterResource(id = R.drawable.icon_vaccination)    )
}