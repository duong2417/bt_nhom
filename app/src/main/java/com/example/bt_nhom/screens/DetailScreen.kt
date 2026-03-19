package com.example.bt_nhom.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bt_nhom.data.NhacCu
import com.example.bt_nhom.viewmodel.NhacCuViewModel

@Composable
fun DetailScreen(item: NhacCu, viewModel: NhacCuViewModel) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Chi tiết nhạc cụ", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Tên: ${item.tenSP}")
        Text("Mã: ${item.maSP}")
        Text("Loại: ${item.loaiSP}")
        Text("Tồn kho: ${item.soLuongTon}")
        Text("Giá bán: ${item.giaBan.toInt()} đ")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            viewModel.updateQuantity(item.id, item.soLuongTon + 1)
        }) {
            Text("Tăng số lượng")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            viewModel.delete(item.id)
        }) {
            Text("Xóa nhạc cụ")
        }
    }
}
///
@Composable
fun DetailScreen(id: Int, navController: NavController, viewModel: NhacCuViewModel) {

    val item = viewModel.getById(id)

    if (item == null) {
        Text("Không tìm thấy sản phẩm")
        return
    }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Chi tiết nhạc cụ")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Tên: ${item.tenSP}")
        Text("Mã: ${item.maSP}")
        Text("Loại: ${item.loaiSP}")
        Text("Tồn kho: ${item.soLuongTon}")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            viewModel.updateQuantity(item.id, item.soLuongTon + 1)
        }) {
            Text("Tăng số lượng")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            viewModel.delete(item.id)
            navController.popBackStack()
        }) {
            Text("Xóa nhạc cụ")
        }
    }
}