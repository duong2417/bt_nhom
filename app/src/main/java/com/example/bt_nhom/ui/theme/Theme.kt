package com.example.bt_nhom.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
/// Đây là nơi kết nối màu sắc vào hệ thống của Android
private val AppColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    background = AppBackground,
    surface = CardWhite,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)

@Composable
fun Bt_nhomTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography(),
        content = content
    )
}