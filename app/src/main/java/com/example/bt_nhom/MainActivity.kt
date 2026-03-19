package com.example.bt_nhom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import com.example.bt_nhom.screens.AddEditScreen
import com.example.bt_nhom.screens.DetailScreen
import com.example.bt_nhom.screens.ListScreen
import com.example.bt_nhom.viewmodel.NhacCuViewModel
//thêm NavHost
class MainActivity : ComponentActivity() {

    private val viewModel = NhacCuViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "list"
            ) {

                composable("list") {
                    ListScreen(navController, viewModel)
                }

                composable("detail/{id}") { backStack ->
                    val id = backStack.arguments?.getString("id")?.toInt() ?: 0
                    DetailScreen(id, navController, viewModel)
                }

                composable("add") {
                    AddEditScreen(navController, viewModel)
                }
            }
        }
    }
}