package com.example.bt_nhom.data

data class NhacCu(
    val id: Int = 0,                    // ID tự tăng
    val tenSP: String,                    // Tên nhạc cụ
    val maSP: String,                     // Mã (ví dụ: GTR-001, PNO-002...)
    val loaiSP: String, 	// Loại sản phẩm (ví dụ: Guitar, Piano, sáo, trống,....) thêm này để mình lọc
    val soLuongTon: Int,                // Số lượng tồn kho
    val giaBan: Double,                 // Giá bán (đơn vị: VND) - kiểu Double để hỗ trợ số thập phân
//    val giaNhap: Double,
    val moTa: String = "",              // Mô tả chi tiết (tùy chọn)
    val hinhAnh: String? = null         // URL hoặc tên file ảnh (nếu sau này muốn thêm hình)
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
    NhacCu(1, "Guitar Yamaha", "GTR-001", "Guitar", 10, 2500000.0, "test description NhacCu 1"),
    NhacCu(2, "Piano điện Casio", "PNO-002", "Piano", 5, 8000000.0),
    NhacCu(3, "Trống Jazz", "DRM-003", "Trống", 3, 4500000.0)
)