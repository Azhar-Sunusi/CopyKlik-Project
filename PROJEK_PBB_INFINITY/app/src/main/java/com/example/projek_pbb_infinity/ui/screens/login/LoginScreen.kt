package com.example.projek_pbb_infinity.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projek_pbb_infinity.R

// Gunakan Enum agar kode lebih mudah dibaca (Sesuai prinsip Clean Code)
enum class ScreenState { WELCOME, LOGIN, SIGNUP }

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var currentScreen by remember { mutableStateOf(ScreenState.WELCOME) }

    // State Input
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val peachBackground = Color(0xFFF3E4D4)
    val blueButton = Color(0xFF8BA9C7)

    Surface(modifier = Modifier.fillMaxSize(), color = peachBackground) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (currentScreen) {
                ScreenState.WELCOME -> {
                    // --- WELCOME SCREEN ---
                    Text(text = "INFINITY", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color(0xFF444444))

                    Spacer(modifier = Modifier.height(30.dp))

                    Image(
                        painter = painterResource(id = R.drawable.logo_infinity),
                        contentDescription = null,
                        modifier = Modifier.size(200.dp)
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    Button(
                        onClick = { currentScreen = ScreenState.LOGIN },
                        modifier = Modifier.fillMaxWidth().height(55.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = blueButton)
                    ) {
                        Text("LOG IN", color = Color.White, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { currentScreen = ScreenState.SIGNUP },
                        modifier = Modifier.fillMaxWidth().height(55.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = blueButton)
                    ) {
                        Text("Sign up", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }

                ScreenState.LOGIN -> {
                    // --- LOGIN SCREEN ---
                    Text(text = "WELCOME!!", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color(0xFF444444))
                    Text(text = "Login", fontSize = 20.sp, modifier = Modifier.padding(top = 8.dp, bottom = 40.dp))

                    CustomTextField(value = email, onValueChange = { email = it }, label = "Name/Email")
                    Spacer(modifier = Modifier.height(16.dp))
                    CustomTextField(value = password, onValueChange = { password = it }, label = "Password", isPassword = true)

                    Spacer(modifier = Modifier.height(40.dp))

                    Button(
                        onClick = { onLoginSuccess() },
                        modifier = Modifier.fillMaxWidth().height(55.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = blueButton)
                    ) {
                        Text("Log In", color = Color.White, fontWeight = FontWeight.Bold)
                    }

                    TextButton(onClick = { currentScreen = ScreenState.WELCOME }) {
                        Text("Back", color = Color.Gray)
                    }
                }

                ScreenState.SIGNUP -> {
                    // --- SIGN UP SCREEN ---
                    Text(text = "WELCOME!!", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color(0xFF444444))
                    Text(text = "Sign Up", fontSize = 20.sp, modifier = Modifier.padding(top = 8.dp, bottom = 30.dp))

                    CustomTextField(value = name, onValueChange = { name = it }, label = "Name")
                    Spacer(modifier = Modifier.height(12.dp))
                    CustomTextField(value = phone, onValueChange = { phone = it }, label = "Phone number")
                    Spacer(modifier = Modifier.height(12.dp))
                    CustomTextField(value = email, onValueChange = { email = it }, label = "Email")
                    Spacer(modifier = Modifier.height(12.dp))
                    CustomTextField(value = password, onValueChange = { password = it }, label = "Password", isPassword = true)

                    Spacer(modifier = Modifier.height(30.dp))

                    Button(
                        onClick = { currentScreen = ScreenState.LOGIN },
                        modifier = Modifier.fillMaxWidth().height(55.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = blueButton)
                    ) {
                        Text("Next", color = Color.White, fontWeight = FontWeight.Bold)
                    }

                    TextButton(onClick = { currentScreen = ScreenState.WELCOME }) {
                        Text("Back", color = Color.Gray)
                    }
                }
            }
        }
    }
}

@Composable
fun CustomTextField(value: String, onValueChange: (String) -> Unit, label: String, isPassword: Boolean = false) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.LightGray
        )
    )
}