package com.example.bt_nhom.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
//import androidx.appcompat.app.AppCompatActivity
import com.example.bt_nhom.data.NhacCu
import com.example.bt_nhom.viewmodel.ProductViewModel

class AddEditScreen : ComponentActivity() {

    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ProductViewModel()

        // TODO: nhập dữ liệu từ EditText

        val nhacCu = NhacCu(
            id = 1,
            tenSP = "Guitar Yamaha",
            maSP = "GTR-001",
            loaiSP = "Guitar",
            soLuongTon = 10,
            giaBan = 2500000.0,
//            giaNhap = 1800000.0
        )

        viewModel.add(nhacCu)
    }
}