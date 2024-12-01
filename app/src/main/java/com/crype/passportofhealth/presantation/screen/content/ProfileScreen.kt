package com.crype.passportofhealth.presantation.screen.content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.crype.passportofhealth.R
import com.crype.passportofhealth.presantation.components.UserInfoSection
import com.crype.passportofhealth.presantation.components.dialog.AddUserInfoDialog
import com.crype.passportofhealth.presantation.viewModel.UserViewModel
import org.koin.androidx.compose.get

@Composable
fun ProfileScreen(
    modifier: Modifier,
    viewModel: UserViewModel = get()
) {

    val user by viewModel.user
    val isDialogVisible by viewModel.isDialogVisible
    if (isDialogVisible)
        AddUserInfoDialog(
            userModel = user,
            setShowDialog = {
                viewModel.toggleDialogVisibility()
            }) {
            viewModel.updateUser(it)
        }
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
            text = "${user.surname} ${user.name} ${user.lastname}",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(25.dp))
        UserInfoSection("Адрес", user.address)
        UserInfoSection("Место работы", user.workPlace)
        UserInfoSection("Номер телефона", user.phoneNumber)
        UserInfoSection("Почта", user.email)

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Изменить",
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable {
                viewModel.showDialog()
            }
        )

    }
}
