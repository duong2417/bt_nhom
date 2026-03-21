package com.example.bt_nhom.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bt_nhom.components.AppPrimaryButton
import com.example.bt_nhom.components.MyAppbar
import com.example.bt_nhom.viewmodel.NhacCuViewModel

///nhận id từ List
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(id: Int, navController: NavController, viewModel: NhacCuViewModel) {

    val item = viewModel.getById(id)

    if (item == null) {
        Text("Không tìm thấy sản phẩm")
        return
    }

    Scaffold(
        topBar = {
            MyAppbar(
                navController = navController,
                title = "Chi tiết nhạc cụ",
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            Text("Tên: ${item.tenSP}")
            Text("Mã: ${item.maSP}")
            Text("Loại: ${item.loaiSP}")
            Text("Tồn kho: ${item.soLuongTon}")
            Text("Giá: ${item.formatGiaBan()} đ")
            Text("Giá trị tồn kho: ${item.formatGiaTriTonKho()} đ")

            Spacer(modifier = Modifier.height(20.dp))

            AppPrimaryButton(text = "Tăng số lượng", onClick = {
                viewModel.updateQuantity(item.id, item.soLuongTon + 1)
            })

            Spacer(modifier = Modifier.height(10.dp))

            AppPrimaryButton(text = "Xóa nhạc cụ", onClick = {
                viewModel.delete(item.id)
                navController.popBackStack()
            })
        }
    }
}