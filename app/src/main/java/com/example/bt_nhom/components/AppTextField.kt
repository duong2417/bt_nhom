package com.example.bt_nhom.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bt_nhom.ui.theme.*

@Composable
fun AppTextField(
    label: String? = null,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "Tìm sản phẩm, mã, loại...",
    modifier: Modifier = Modifier
) {

    OutlinedTextField(
        label = if (label != null) { { Text(text = label) } } else null,
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = Color(0xFF6E6E6E)
            )
        },

        modifier = modifier.fillMaxWidth().size(50.dp),

        singleLine = true,

        shape = RoundedCornerShape(10.dp),

        colors = OutlinedTextFieldDefaults.colors(

            // màu nền giống ảnh
            unfocusedContainerColor = LightGrey,
            focusedContainerColor = LightGrey,

            // màu viền giống ảnh
            unfocusedBorderColor = Color(0xFFE2E7EB),
            focusedBorderColor = BorderGrey,

//            cursorColor = Color.Black,
//            focusedTextColor = Color.Black,
//            unfocusedTextColor = Color.Black
        )
    )
}