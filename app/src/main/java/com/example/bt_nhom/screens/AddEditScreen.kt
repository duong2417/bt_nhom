package com.example.bt_nhom.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bt_nhom.components.AppPrimaryButton
import com.example.bt_nhom.components.AppTextField
import com.example.bt_nhom.components.MyAppbar
import com.example.bt_nhom.data.NhacCu
import com.example.bt_nhom.viewmodel.NhacCuViewModel

///bấm lưu → quay về List
@Composable
fun AddEditScreen(navController: NavController, viewModel: NhacCuViewModel) {

    var ten by remember { mutableStateOf("") }
    var ma by remember { mutableStateOf("") }
    var loai by remember { mutableStateOf("") }
    var soLuong by remember { mutableStateOf("") }

    Scaffold (
        topBar = {
            MyAppbar(
                navController = navController,
                title = "Thêm nhạc cụ",
            )
        }
    ) {
        padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {

            Spacer(modifier = Modifier.height(16.dp))

            AppTextField(value = ten, onValueChange = { ten = it }, placeholder = "Tên nhạc cụ")

            Spacer(modifier = Modifier.height(10.dp))

            AppTextField(value = ma, onValueChange = { ma = it }, placeholder = "Mã nhạc cụ")

            Spacer(modifier = Modifier.height(10.dp))

            AppTextField(value = loai, onValueChange = { loai = it }, placeholder = "Loại nhạc cụ")

            Spacer(modifier = Modifier.height(10.dp))

            AppTextField(
                value = soLuong,
                onValueChange = { soLuong = it },
                placeholder = "Số lượng"
            )

            Spacer(modifier = Modifier.height(20.dp))

            AppPrimaryButton(onClick = {

                val item = NhacCu(
                    id = viewModel.getAll().size + 1,
                    tenSP = ten,
                    maSP = ma,
                    loaiSP = loai,
                    soLuongTon = soLuong.toInt(),
                    giaBan = 0.0,
                    moTa = "",
                    hinhAnh = null
                    //                giaNhap = 0.0
                )

                viewModel.add(item)

                navController.popBackStack()

            }, text = "Lưu nhạc cụ")
        }
    }
}