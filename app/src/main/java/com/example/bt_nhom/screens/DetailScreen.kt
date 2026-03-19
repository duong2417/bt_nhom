package com.example.bt_nhom.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
//import androidx.appcompat.app.AppCompatActivity
import com.example.bt_nhom.viewmodel.ProductViewModel

class DetailScreen : ComponentActivity() {

    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ProductViewModel()

        val id = intent.getIntExtra("id", 0)

        val nhacCu = viewModel.getById(id)

        // TODO: hiển thị chi tiết sản phẩm
    }
}