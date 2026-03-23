package com.example.bt_nhom.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bt_nhom.components.AppTextField
import com.example.bt_nhom.data.NhacCu
import com.example.bt_nhom.ui.theme.*
import com.example.bt_nhom.viewmodel.NhacCuViewModel

///bấm vào item → sang Detail
@Composable
fun ListScreen(navController: NavController, viewModel: NhacCuViewModel) {

    val list = viewModel.getAll()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add") },
                containerColor = PrimaryBlue,
                shape = RoundedCornerShape(30.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        },
//        floatingActionButtonPosition = FabPosition.End

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Danh sách Sản phẩm",
//                style = MaterialTheme.typography.titleLarge
                style = Typography.titleLarge
            )

            Spacer(modifier = Modifier.height(12.dp))

            var searchQuery = ""
            AppTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn () {
                items(list) { item ->
                    ProductItem(item, navController)
                }
            }
        }
    }
}

@Composable
fun ProductItem(item: NhacCu, navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 14.dp)
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(22.dp),
                ambientColor = Color(0xFFD6CFC4),
                spotColor = Color(0xFFBEB6AA)
            )
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(22.dp)
            )
            .clickable {
                navController.navigate("detail/${item.id}")
            }
    ) {

        Row(
            modifier = Modifier.padding(14.dp)
        ) {

            // hình nhạc cụ
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(LightGrey)
//                    .background(Color(0xFFEFE7DB))
            ) {

                Image(
                    painter = painterResource(item.hinhAnh ?: 0),
                    contentDescription = item.tenSP, // Good practice to use the product name
                    modifier = Modifier.fillMaxSize() // Optional: makes image fill the box
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = item.tenSP,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Mã SP: ${item.maSP}",
                    color = Color(0xFF6A6A6A)
                )

                Text("Tồn kho: ${item.soLuongTon.toString()}")

                Row {

                    Text("Giá: ")

                    Text(
                        item.formatGiaBan(),
                        color = PrimaryBlue
//                        color = Color(0xFF3FA34D)
                    )
                }
            }

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = Color(0xFF9E9E9E)
            )
        }
    }
}

