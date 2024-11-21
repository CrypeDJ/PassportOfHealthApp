package com.crype.passportofhealth.presantation.screen.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.crype.passportofhealth.domain.model.ListItemModel
import com.crype.passportofhealth.presantation.components.buttons.AddButtonComponent
import com.crype.passportofhealth.presantation.components.ListComponent
import com.crype.passportofhealth.presantation.components.TitleComponent

@Composable
fun DiseaseScreen(
    navController: NavController,
    modifier: Modifier
){
    val exampleList: MutableList<ListItemModel> = mutableListOf(
        ListItemModel("Covid","15.02.2024"),
        ListItemModel("Covid","15.02.2024"),
        ListItemModel("Covid","15.02.2024"),
        ListItemModel("Covid","15.02.2024"),
        ListItemModel("Covid","15.02.2024"),
        ListItemModel("Covid","15.02.2024"),
        ListItemModel("Covid","15.02.2024"),
    )
    Column(
        modifier = modifier.padding(horizontal = 20.dp)
    ) {
        TitleComponent(
            text = "Хронические заболевания и аллергии",
            size = 30.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        AddButtonComponent {

        }
        Spacer(modifier = Modifier.height(25.dp))
        ListComponent(
            padding = PaddingValues(),
            list = exampleList
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DiseasePreview(){
    DiseaseScreen(navController = rememberNavController(), Modifier)
}