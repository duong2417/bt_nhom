//package com.example.bt_nhom.screens
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.activity.ComponentActivity
////import androidx.appcompat.app.AppCompatActivity
//import com.example.bt_nhom.viewmodel.ProductViewModel
//
//class ListScreen : ComponentActivity() {
//
//    private lateinit var viewModel: ProductViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        viewModel = ProductViewModel()
//
//        // TODO: hiển thị danh sách nhạc cụ (RecyclerView)
//    }
//
//    fun openDetail(id: Int) {
//        val intent = Intent(this, DetailScreen::class.java)
//        intent.putExtra("id", id)
//        startActivity(intent)
//    }
//}

package com.example.bt_nhom.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bt_nhom.data.NhacCu
import com.example.bt_nhom.ui.theme.Bt_nhomTheme

@Composable
fun ListScreen() {

    val fakeData = listOf(
        NhacCu(1, "Guitar Yamaha", "GTR-001", "Guitar", 10, 2500000.0),
        NhacCu(2, "Piano điện Casio", "PNO-002", "Piano", 5, 8000000.0),
        NhacCu(3, "Trống Jazz", "DRM-003", "Trống", 3, 4500000.0)
    )

    Scaffold(
//        topBar = {
//            TopAppBar(title = { Text("Danh sách nhạc cụ") })
//        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            items(fakeData) { item ->
                NhacCuItem(item)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun NhacCuItem(nhacCu: NhacCu) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(text = nhacCu.tenSP, style = MaterialTheme.typography.titleMedium)

            Text(text = "Mã: ${nhacCu.maSP}")
            Text(text = "Loại: ${nhacCu.loaiSP}")
            Text(text = "Tồn kho: ${nhacCu.soLuongTon}")

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Giá: ${nhacCu.giaBan.toInt()} đ",
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}