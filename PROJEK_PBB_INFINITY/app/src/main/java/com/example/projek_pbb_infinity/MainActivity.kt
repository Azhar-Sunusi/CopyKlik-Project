package com.example.projek_pbb_infinity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.projek_pbb_infinity.ui.navigation.SetupNavGraph
import com.example.projek_pbb_infinity.ui.screens.login.LoginScreen // Sesuaikan folder
import com.example.projek_pbb_infinity.ui.theme.PROJEK_PBB_INFINITYTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // Sudah benar pakai C kapital
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SetupNavGraph(navController = navController)
            PROJEK_PBB_INFINITYTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LoginScreen(onLoginSuccess = {
                        // Kosongkan dulu agar aplikasi bisa terbuka tanpa crash
                    }) // Memanggil desain login kamu
                }
            }
        }
    }
}
