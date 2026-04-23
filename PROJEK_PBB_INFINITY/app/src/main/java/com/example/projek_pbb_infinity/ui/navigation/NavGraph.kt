package com.example.projek_pbb_infinity.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.projek_pbb_infinity.ui.screens.login.LoginScreen
import com.example.projek_pbb_infinity.ui.screens.home.HomeScreen
import com.example.projek_pbb_infinity.ui.screens.transaction.TransactionScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login" // Halaman pertama yang muncul
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    // Pindah ke home dan hapus login dari history agar tidak bisa back
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        composable("home") {
            HomeScreen(navController)
        }
        composable("transaction") {
            TransactionScreen(navController)
        }
    }
}