package com.crype.passportofhealth.presantation.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crype.passportofhealth.presantation.ui.theme.MediumGreen

@Composable
fun AddButtonComponent(
    onClick: () -> Unit
){
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = MediumGreen
        ),

    ) {
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = null,
            modifier = Modifier.requiredSize(45.dp)
        )
    }
}

@Preview
@Composable
fun AddButtonPreview(){
    AddButtonComponent {

    }
}