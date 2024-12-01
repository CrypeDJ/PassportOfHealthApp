package com.crype.passportofhealth.presantation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crype.passportofhealth.R

@Composable
fun BottomBarComponent(
    onVaccinationClick: () -> Unit,
    onLifecycleClick: () -> Unit,
    onHealthIndicatorsClick: () -> Unit,
    onStartClick:() ->Unit,
    onDiseaseClick:() -> Unit
) {
    val spacerWidth = 10.dp
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onLifecycleClick,
            modifier = Modifier.requiredSize(60.dp)
            ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_lifestyle),
                contentDescription = "",
                Modifier.requiredSize(30.dp)
            )
        }
        Spacer(modifier = Modifier.width(spacerWidth))
        IconButton(
            onClick = onHealthIndicatorsClick,
            modifier = Modifier.requiredSize(60.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_health_indicator),
                contentDescription = "",
                Modifier.requiredSize(30.dp),
            )
        }
        Spacer(modifier = Modifier.width(spacerWidth))
        IconButton(
            onClick = onStartClick,
            modifier = Modifier.requiredSize(60.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Home,
                contentDescription = "",
                Modifier.requiredSize(35.dp)
            )
        }
        Spacer(modifier = Modifier.width(spacerWidth))
        IconButton(
            onClick = onVaccinationClick,
            modifier = Modifier.requiredSize(60.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_vaccination),
                contentDescription = "",
                Modifier.requiredSize(30.dp)
            )
        }
        Spacer(modifier = Modifier.width(spacerWidth))
        IconButton(
            onClick = onDiseaseClick,
            modifier = Modifier.requiredSize(60.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_illness),
                contentDescription = "",
                Modifier.requiredSize(30.dp)
            )
        }
    }
}