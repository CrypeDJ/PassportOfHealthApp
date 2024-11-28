package com.crype.passportofhealth.presantation.screen.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.crype.passportofhealth.R
import com.crype.passportofhealth.domain.model.HealthIndicatorsModel
import com.crype.passportofhealth.presantation.components.TitleComponent
import com.crype.passportofhealth.presantation.components.enterInfo.InfoScreenComponent
import com.crype.passportofhealth.presantation.components.enterInfo.PressureComponent

@Composable
fun HealthIndicatorScreen(
    navController: NavController,
    modifier: Modifier,
) {
    var example by remember {
        mutableStateOf(
            HealthIndicatorsModel(
                weight = "72",
                height = "185",
                highPressure =  "120",
                lowPressure = "90",
                glucose = "80",
                cholesterol = "4"
            )
        )
    }
    var isEditText by remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            TitleComponent(
                text = "Показатели здоровья",
                size = 30.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { /*TODO*/ //save to db
                    isEditText = !isEditText
                },
                modifier = Modifier.requiredSize(60.dp)
            ) {
                Icon(
                    painter = painterResource(
                        id = if (isEditText) R.drawable.icon_save
                        else R.drawable.icon_edit
                    ),
                    contentDescription = null,
                    modifier = Modifier.requiredSize(25.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                InfoScreenComponent(
                    isEditText = isEditText,
                    name = "Вес(кг)",
                    value = example.weight,
                    keyboardType = KeyboardType.Number
                ) { example = example.copy(weight = it) }
            }
            item {
                InfoScreenComponent(
                    isEditText = isEditText,
                    name = "Рост(см)",
                    value = example.height,
                    keyboardType = KeyboardType.Number
                ) { example = example.copy(height = it) }
            }
            item {
                InfoScreenComponent(
                    isEditText = false,
                    name = "ИМТ",
                    value = (example.weight.toFloat() / (example.height.toFloat() / 100 * example.height.toFloat() / 100)).toString(),
                    keyboardType = KeyboardType.Number
                ) {}
            }
            item {
                PressureComponent(
                    isEditText = isEditText,
                    name = "Давление",
                    highPressure = example.highPressure,
                    lowPressure = example.lowPressure,
                    onHighChange = { example = example.copy(highPressure = it) },
                    onLowChange = { example = example.copy(lowPressure = it) }
                )
            }
            item {
                InfoScreenComponent(
                    isEditText = isEditText,
                    name = "Холестирин",
                    value = example.cholesterol,
                    keyboardType = KeyboardType.Number
                ) { example = example.copy(cholesterol = it) }
            }
            item {
                InfoScreenComponent(
                    isEditText = isEditText,
                    name = "Глюкоза",
                    value = example.glucose,
                    keyboardType = KeyboardType.Number
                ) { example = example.copy(glucose = it) }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HealthIndicatorPreview() {
    HealthIndicatorScreen(navController = rememberNavController(), modifier = Modifier)
}