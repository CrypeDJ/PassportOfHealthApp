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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.passportofhealth.R
import com.crype.passportofhealth.presantation.components.TitleComponent
import com.crype.passportofhealth.presantation.components.enterInfo.InfoScreenComponent
import com.crype.passportofhealth.presantation.components.enterInfo.PressureComponent
import com.crype.passportofhealth.presantation.viewModel.HealthIndicatorViewModel
import org.koin.androidx.compose.get

@Composable
fun HealthIndicatorScreen(
    modifier: Modifier,
    viewModel: HealthIndicatorViewModel = get()
) {
    val healthIndicators by viewModel.healthIndicators
    val isEditMode by viewModel.isEditMode
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
                onClick = {
                    if (isEditMode) viewModel.saveHealthIndicators()
                    else viewModel.toggleEditMode()
                },
                modifier = Modifier.requiredSize(60.dp)
            ) {
                Icon(
                    painter = painterResource(
                        id = if (isEditMode) R.drawable.icon_save
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
                    isEditText = isEditMode,
                    name = "Вес(кг)",
                    value = healthIndicators.weight,
                    keyboardType = KeyboardType.Number
                ) {
                    viewModel.updateHealthIndicator(healthIndicators.copy(weight = it))
                }
            }
            item {
                InfoScreenComponent(
                    isEditText = isEditMode,
                    name = "Рост(см)",
                    value = healthIndicators.height,
                    keyboardType = KeyboardType.Number
                ) {
                    viewModel.updateHealthIndicator(healthIndicators.copy(height = it))
                }
            }
            item {
                InfoScreenComponent(
                    isEditText = false,
                    name = "ИМТ",
                    value = viewModel.imtCalculate(),
                    keyboardType = KeyboardType.Number
                ) {}
            }
            item {
                PressureComponent(
                    isEditText = isEditMode,
                    name = "Давление",
                    highPressure = healthIndicators.highPressure,
                    lowPressure = healthIndicators.lowPressure,
                    onHighChange = { viewModel.updateHealthIndicator(healthIndicators.copy(highPressure = it)) },
                    onLowChange = { viewModel.updateHealthIndicator(healthIndicators.copy(lowPressure = it))}
                )
            }
            item {
                InfoScreenComponent(
                    isEditText = isEditMode,
                    name = "Холестирин",
                    value = healthIndicators.cholesterol,
                    keyboardType = KeyboardType.Number
                ) {
                    viewModel.updateHealthIndicator(healthIndicators.copy(cholesterol = it))
                }
            }
            item {
                InfoScreenComponent(
                    isEditText = isEditMode,
                    name = "Глюкоза",
                    value = healthIndicators.glucose,
                    keyboardType = KeyboardType.Number
                ) {
                    viewModel.updateHealthIndicator(healthIndicators.copy(glucose = it))
                }
            }
        }
    }
}
