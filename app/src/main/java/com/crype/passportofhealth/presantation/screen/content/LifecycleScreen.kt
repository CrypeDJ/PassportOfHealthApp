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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.passportofhealth.R
import com.crype.passportofhealth.presantation.components.TitleComponent
import com.crype.passportofhealth.presantation.components.enterInfo.ChooseInfoScreenComponent
import com.crype.passportofhealth.presantation.viewModel.LifecycleViewModel
import org.koin.androidx.compose.get

@Composable
fun LifecycleScreen(
    modifier: Modifier,
    viewModel: LifecycleViewModel = get()
) {
    val lifestyle by viewModel.lifestyle
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
                text = "Образ жизни",
                size = 30.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { /*TODO*/
                    if (isEditMode) viewModel.saveLifestyle()
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
        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditMode,
                    name = "Тип питания",
                    value = lifestyle.typeOfNutrition,
                    listOfVariants = mutableListOf(
                        "Обычный",
                        "Вегетарианство",
                        "Веганство",
                        "Палео диета",
                        "Кетогенная диета",
                        "Средиземноморская диета",
                        "Диета Дюкана",
                        "Другое",
                    )
                ) {
                    viewModel.updateLifestyle(lifestyle.copy(typeOfNutrition = it))
                }
            }
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditMode,
                    name = "Режим питания",
                    value = lifestyle.modeOfNutrition,
                    listOfVariants = mutableListOf(
                        "3 раза в день",
                        "2 раза в день",
                        "4 раза в день",
                        "5 раз в день",
                        "Больше 5 раз в день",
                        "Менее 2 раз в день",
                    )
                ) {
                    viewModel.updateLifestyle(lifestyle.copy(modeOfNutrition = it))
                }
            }
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditMode,
                    name = "Курение",
                    value = lifestyle.smoking,
                    listOfVariants = mutableListOf(
                        "Никогда",
                        "Реже одного раза в месяц",
                        "Несколько раз в месяц",
                        "Несколько раз в неделю",
                        "1-2 раза в день",
                        "Более 2 раз в день",
                    )
                ) {
                    viewModel.updateLifestyle(lifestyle.copy(smoking = it))
                }
            }
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditMode,
                    name = "Алкоголь",
                    value = lifestyle.alcohol,
                    listOfVariants = mutableListOf(
                        "Никогда",
                        "Реже одного раза в месяц",
                        "Несколько раз в месяц",
                        "Несколько раз в неделю",
                        "1-2 раза в день",
                        "Более 2 раз в день",
                    )
                ) {
                    viewModel.updateLifestyle(lifestyle.copy(alcohol = it))
                }
            }
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditMode,
                    name = "Наркота",
                    value = lifestyle.drugs,
                    listOfVariants = mutableListOf(
                        "Никогда",
                        "Реже одного раза в месяц",
                        "Несколько раз в месяц",
                        "Несколько раз в неделю",
                        "1-2 раза в день",
                        "Более 2 раз в день",
                    )
                ) {
                    viewModel.updateLifestyle(lifestyle.copy(drugs = it))
                }
            }
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditMode,
                    name = "Тип физ.активности",
                    value = lifestyle.physicalActivity,
                    listOfVariants = mutableListOf(
                        "Никогда",
                        "Меньше одного раза в неделю",
                        "1-2 раза в неделю",
                        "3-4 раза в неделю",
                        "5-6 раз в неделю",
                        "Ежедневно",
                        "Больше одного раза в день"
                    )
                ) {
                    viewModel.updateLifestyle(lifestyle.copy(physicalActivity = it))
                }
            }
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditMode,
                    name = "Частота физ. активности",
                    value = lifestyle.frequencyOfPhysical,
                    listOfVariants = mutableListOf(
                        "Нет",
                        "Пешие прогулки",
                        "Легкая зарядка или растяжка",
                        "Кардио тренировки",
                        "Силовые тренировки",
                        "Спортивные игры",
                        "Йога или пилатес",
                        "Танцы или аэробика",
                        "Гибридные тренировки"
                    )
                ) {
                    viewModel.updateLifestyle(lifestyle.copy(frequencyOfPhysical = it))
                }
            }
        }
    }
}

