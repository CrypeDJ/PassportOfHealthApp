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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.crype.passportofhealth.R
import com.crype.passportofhealth.domain.model.LifestyleModel
import com.crype.passportofhealth.presantation.components.enterInfo.ChooseInfoScreenComponent
import com.crype.passportofhealth.presantation.components.TitleComponent

@Composable
fun LifecycleScreen(
    navController: NavController,
    modifier: Modifier
) {
    val example = LifestyleModel(
        "Сбалансированное",
        "3 раза в день",
        "нет",
        "1 раз в неделю",
        "каждый день",
        "нет",
        "никогда",
    )
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
                text = "Образ жизни",
                size = 30.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { /*TODO*/
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
        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditText,
                    name = "Тип питания",
                    value = example.typeOfNutrition,
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
                )
            }
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditText,
                    name = "Режим питания",
                    value = example.modeOfNutrition,
                    listOfVariants = mutableListOf(
                        "3 раза в день",
                        "2 раза в день",
                        "4 раза в день",
                        "5 раз в день",
                        "Больше 5 раз в день",
                        "Менее 2 раз в день",
                    )
                )
            }
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditText,
                    name = "Курение",
                    value = example.smoking,
                    listOfVariants = mutableListOf(
                        "Никогда",
                        "Реже одного раза в месяц",
                        "Несколько раз в месяц",
                        "Несколько раз в неделю",
                        "1-2 раза в день",
                        "Более 2 раз в день",
                    )
                )
            }
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditText,
                    name = "Алкоголь",
                    value = example.alcohol,
                    listOfVariants = mutableListOf(
                        "Никогда",
                        "Реже одного раза в месяц",
                        "Несколько раз в месяц",
                        "Несколько раз в неделю",
                        "1-2 раза в день",
                        "Более 2 раз в день",
                    )
                )
            }
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditText,
                    name = "Наркота",
                    value = example.drugs,
                    listOfVariants = mutableListOf(
                        "Никогда",
                        "Реже одного раза в месяц",
                        "Несколько раз в месяц",
                        "Несколько раз в неделю",
                        "1-2 раза в день",
                        "Более 2 раз в день",
                    )
                )
            }
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditText,
                    name = "Частота физ. активности",
                    value = example.physicalActivity,
                    listOfVariants = mutableListOf(
                        "Никогда",
                        "Меньше одного раза в неделю",
                        "1-2 раза в неделю",
                        "3-4 раза в неделю",
                        "5-6 раз в неделю",
                        "Ежедневно",
                        "Больше одного раза в день"
                    )
                )
            }
            item {
                ChooseInfoScreenComponent(
                    isEditText = isEditText,
                    name = "Тип физ.активности",
                    value = example.frequencyOfPhysical,
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
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LifestylePreview()
{
    LifecycleScreen(navController = rememberNavController(), modifier = Modifier)
}