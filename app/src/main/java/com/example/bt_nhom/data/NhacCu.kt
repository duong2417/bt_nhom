//package com.example.bt_nhom.data
//
//data class NhacCu(
//    val id: Int = 0,
//    val tenSP: String,
//    val maSP: String,
//    val loaiSP: String,
//    val soLuongTon: Int,
//    val giaBan: Double,
//    val giaNhap: Double,
//    val moTa: String = "",
//    val hinhAnh: String? = null
//) {
//    val giaTriTonKho: Double
//        get() = soLuongTon * giaBan
//
//    val loiNhuanTonKho: Double
//        get() = soLuongTon * (giaBan - giaNhap)
//
//    fun formatGiaBan(): String = String.format("%,.0f ₫", giaBan)
//}

package com.example.bt_nhom.data

data class NhacCu(
    val id: Int,
    val tenSP: String,
    val maSP: String,
    val loaiSP: String,
    val soLuongTon: Int,
    val giaBan: Double
)

val fakeData = listOf(
    NhacCu(1, "Guitar Yamaha", "GTR-001", "Guitar", 10, 2500000.0),
    NhacCu(2, "Piano điện Casio", "PNO-002", "Piano", 5, 8000000.0),
    NhacCu(3, "Trống Jazz", "DRM-003", "Trống", 3, 4500000.0)
)