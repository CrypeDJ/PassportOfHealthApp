package com.crype.passportofhealth.presantation.components.enterInfo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChooseInfoScreenComponent(
    isEditText: Boolean,
    name: String,
    value: String,
    listOfVariants: MutableList<String>
) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var text by remember {
        mutableStateOf(value)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "$name: ",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 5.dp)
        )
        Box(
            Modifier.wrapContentSize(Alignment.TopEnd)
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .clickable {
                        isExpanded = if (isEditText) !isExpanded
                        else false
                    }
                    .fillMaxWidth(),
                fontSize = 15.sp,
                textDecoration = if (isEditText) TextDecoration.Underline
                else TextDecoration.None
            )
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                Modifier.wrapContentSize(Alignment.TopEnd)
            ) {
                listOfVariants.forEach { it ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = it,
                                color = Color.Black
                            )
                        },
                        onClick = {
                            text = it
                            isExpanded = false
                        }
                    )
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun ChooseInfoScreenPreview() {
    ChooseInfoScreenComponent(
        isEditText = true,
        name = "Тип питания",
        value = "Сбалансированный",
        listOfVariants = mutableListOf("sfsdf", "sgsdgfsd", "sgsggsdg")
    )
}