package com.example.bt_nhom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bt_nhom.screens.ListScreen
import com.example.bt_nhom.ui.theme.Bt_nhomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bt_nhomTheme {
                ListScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    Bt_nhomTheme {
        ListScreen()
    }
}