package com.crype.passportofhealth.presantation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.crype.passportofhealth.domain.model.VaccinationModel

@Composable
fun ListVaccinationComponent(
    padding: PaddingValues,
    list: MutableList<VaccinationModel>,
    onClick: (Int) -> Unit,
    onLongClick: (Int) -> Unit
) {
    LazyColumn(
        contentPadding = padding,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(list.size) { item ->
            ListItemComponent(
                mainText = list[item].name,
                description = list[item].date,
                onClick = {
                    onClick(item)
                },
                onLongClick = { onLongClick(item) }
            )
        }
    }
}