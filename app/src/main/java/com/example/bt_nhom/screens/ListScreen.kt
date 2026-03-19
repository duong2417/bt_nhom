package com.example.bt_nhom.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bt_nhom.viewmodel.NhacCuViewModel

@Composable
fun ListScreen(viewModel: NhacCuViewModel) {

    val list = viewModel.getAll()

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Danh sách nhạc cụ", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // mở màn hình thêm
        }) {
            Text("Thêm nhạc cụ")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(list) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(item.tenSP)
                        Text("Mã: ${item.maSP}")
                        Text("Tồn kho: ${item.soLuongTon}")
                    }
                }
            }
        }
    }
}

///
@Composable
fun ListScreen(navController: NavController, viewModel: NhacCuViewModel) {

    val list = viewModel.getAll()

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Danh sách nhạc cụ")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("add")
        }) {
            Text("Thêm nhạc cụ")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(list) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    onClick = {
                        navController.navigate("detail/${item.id}")
                    }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(item.tenSP)
                        Text("Mã: ${item.maSP}")
                        Text("Tồn kho: ${item.soLuongTon}")
                    }
                }
            }
        }
    }
}