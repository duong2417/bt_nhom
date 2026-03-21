package com.example.bt_nhom.data

import androidx.annotation.DrawableRes
import com.example.bt_nhom.R

data class NhacCu(
    val id: Int = 0,                    // ID tự tăng
    val tenSP: String,                    // Tên nhạc cụ
    val maSP: String,                     // Mã (ví dụ: GTR-001, PNO-002...)
    val loaiSP: String, 	// Loại sản phẩm (ví dụ: Guitar, Piano, sáo, trống,....) thêm này để mình lọc
    val soLuongTon: Int,                // Số lượng tồn kho
    val giaBan: Double,                 // Giá bán (đơn vị: VND) - kiểu Double để hỗ trợ số thập phân
//    val giaNhap: Double,
    val moTa: String = "",              // Mô tả chi tiết (tùy chọn)
//    val hinhAnh: String? = null         // URL hoặc tên file ảnh (nếu sau này muốn thêm hình)
    @DrawableRes val hinhAnh:Int? = null
) {
    // Hàm tiện ích tính tổng giá trị tồn kho (có thể dùng trong ViewModel hoặc UI)
    val giaTriTonKho: Double
        get() = soLuongTon * giaBan
    // Optional: Hàm tiện ích format giá tiền (có thể dùng trong UI)
    fun formatGiaBan(): String = String.format("%,.0f ₫", giaBan)
//    fun formatGiaNhap(): String = String.format("%,.0f ₫", giaNhap)
    fun formatGiaTriTonKho(): String = String.format("%,.0f ₫", giaTriTonKho)
}

val fakeData = listOf(
    NhacCu(1, "Guitar Yamaha", "GTR-001", "Đàn", 10, 2500000.0, "test description NhacCu 1", R.drawable.guitar1),
    NhacCu(2, "Trống Jazz", "DRM-003", "Trống", 3, 4500000.0, "test description NhacCu 2", R.drawable.nhac_cu2),
    NhacCu(3, "Piano điện Casio", "PNO-002", "Đàn", 5, 8000000.0, "test description NhacCu 3", R.drawable.nhac_cu3),
    NhacCu(4, "Guitar điện", "GTR-002", "Đàn", 6, 8000000.0, "test description NhacCu 4", R.drawable.nhac_cu4),
    NhacCu(5, "Âm li", "PNO-002", "Khác", 5, 8000000.0, "test description NhacCu 5", R.drawable.nhac_cu5),
    )