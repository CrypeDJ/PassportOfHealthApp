package com.crype.passportofhealth.presantation.components.enterInfo

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@Composable
fun DatePickerComponent(
    date: String,
    onDateChange: (String) -> Unit,
    isEditText: Boolean
) {
    val context = LocalContext.current

    val calendar = Calendar.getInstance()
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val selectedDate = String.format("%02d-%02d-%04d", dayOfMonth, month + 1, year)
            onDateChange(selectedDate)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Text(
            text = "Дата: ",
            fontSize = 20.sp,
            modifier = Modifier.padding(end = 5.dp)
        )
        TextField(
            value = date,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    if (isEditText) datePickerDialog.show()
                },
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(15.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DatePickerComponentPreview() {
    DatePickerComponent("", isEditText = true, onDateChange = {})
}