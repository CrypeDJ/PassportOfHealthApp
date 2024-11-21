package com.crype.passportofhealth.presantation.screen.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.crype.passportofhealth.R
import com.crype.passportofhealth.domain.model.UserModel

@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier
) {
    val example = UserModel(
        "Дударев",
        "Алексей",
        "Дмитриевич",
        "г.Новополоцк, ул.Молодёжная, д.188, корп.1, кв.17",
        "клуб 'Plaza'",
        "+375333056785",
        "litowrog@gmail.com",
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Icon(
            painter = painterResource(id = R.drawable.icon_user),
            contentDescription = null,
            modifier = Modifier.requiredSize(100.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "${example.surname} ${example.name} ${example.lastname}",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Адрес",
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = example.address,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Место работы",
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = example.workPlace,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Номер телефона",
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = example.phoneNumber,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Почта",
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = example.email,
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileScreen(navController = rememberNavController(), modifier = Modifier)
}