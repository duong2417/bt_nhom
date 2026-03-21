package com.example.bt_nhom.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bt_nhom.data.NhacCu
import com.example.bt_nhom.viewmodel.NhacCuViewModel

///bấm lưu → quay về List
@Composable
fun AddEditScreen(navController: NavController, viewModel: NhacCuViewModel) {

    var ten by remember { mutableStateOf("") }
    var ma by remember { mutableStateOf("") }
    var loai by remember { mutableStateOf("") }
    var soLuong by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Thêm nhạc cụ")

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = ten, onValueChange = { ten = it }, label = { Text("Tên") })

        Spacer(modifier = Modifier.height(10.dp))

        TextField(value = ma, onValueChange = { ma = it }, label = { Text("Mã") })

        Spacer(modifier = Modifier.height(10.dp))

        TextField(value = loai, onValueChange = { loai = it }, label = { Text("Loại") })

        Spacer(modifier = Modifier.height(10.dp))

        TextField(value = soLuong, onValueChange = { soLuong = it }, label = { Text("Số lượng") })

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            val item = NhacCu(
                id = viewModel.getAll().size + 1,
                tenSP = ten,
                maSP = ma,
                loaiSP = loai,
                soLuongTon = soLuong.toInt(),
                giaBan = 0.0,
//                giaNhap = 0.0
            )

            viewModel.add(item)

            navController.popBackStack()

        }) {
            Text("Lưu nhạc cụ")
        }
    }
}