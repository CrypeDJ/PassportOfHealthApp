package com.crype.passportofhealth.presantation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crype.passportofhealth.domain.model.ListItemModel

@Composable
fun ListComponent(
    padding: PaddingValues,
    list: MutableList<ListItemModel>
){
    LazyColumn(
        contentPadding = padding,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(list.size) {item ->
            ListItemComponent(
                mainText = list[item].name,
                description = list[item].description,
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun ListPreview(){

}

