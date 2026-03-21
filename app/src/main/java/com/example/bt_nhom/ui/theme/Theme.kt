package com.example.bt_nhom.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
/// Đây là nơi kết nối màu sắc vào hệ thống của Android
private val AppColorScheme = lightColorScheme(
    background = PaperBg,
    surface = CardBg,
    primary = StockGreen,
    onBackground = TitleColor
)

@Composable
fun Bt_nhomTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography(),
        content = content
    )
}