package com.example.projek_pbb_infinity.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projek_pbb_infinity.R

// Definisi Warna sesuai desain gambar
val BackgroundCream = Color(0xFFF3E4D4)
val BlueCard = Color(0xFF8BA9C7)
val HeaderBlue = Color(0xFF8BA9C7)

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            // --- NAVIGATION BAR BAWAH ---
            BottomAppBar(
                containerColor = Color.White,
                modifier = Modifier.height(70.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Icon Home (Lingkaran)
                    Surface(
                        shape = CircleShape,
                        color = Color(0xFFB0C4DE),
                        modifier = Modifier.size(50.dp)
                    ) {
                        IconButton(onClick = { }) {
                            Icon(painter = painterResource(id = R.drawable.ic_image), contentDescription = null, modifier = Modifier.size(30.dp))
                        }
                    }
                    // Icon List
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.List, contentDescription = null, modifier = Modifier.size(35.dp))
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundCream)
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            // --- HEADER: PROFIL ---
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(HeaderBlue)
                    .padding(16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = CircleShape,
                        modifier = Modifier.size(55.dp),
                        color = Color.White.copy(alpha = 0.5f)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_image),
                            contentDescription = null,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text("Hai..!", color = Color.White, fontSize = 14.sp)
                        Text("Azhar", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Text("User", color = Color.White, fontWeight = FontWeight.SemiBold)
                }
            }

            // --- TOTAL PESANAN ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE8D5C4)) // Warna krem sedikit lebih gelap
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Total Pesanan", fontSize = 14.sp)
                    Text("April 2026", fontSize = 14.sp)
                }
                Text(
                    "Rp.25.000.000.000.00",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // --- TOMBOL ADD FILE ---
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f).height(65.dp),
                    shape = RoundedCornerShape(topStart = 35.dp, bottomStart = 35.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BlueCard)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_print),
                            contentDescription = null,
                            modifier = Modifier.size(35.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text("Add File Here!", fontSize = 18.sp, color = Color.White)
                    }
                }
                // Icon panah naik-turun dan play (Visual saja)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(painter = painterResource(id = R.drawable.ic_image), contentDescription = null, modifier = Modifier.size(30.dp))
                Icon(painter = painterResource(id = R.drawable.ic_image), contentDescription = null, modifier = Modifier.size(35.dp))
            }

            Spacer(modifier = Modifier.height(20.dp))

            // --- DAFTAR LAYANAN ---
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                ServiceItem("Brosur A4", "RP. 15.000/lembar", R.drawable.ic_image)
                ServiceItem("Kartu Nama", "RP. 10.000/PCS", R.drawable.ic_card)
                ServiceItem("Fotocopy", "RP.2.000/lembar", R.drawable.ic_copy)
                ServiceItem("Print", "RP.5.000/lembar", R.drawable.ic_print)
            }
        }
    }
}

@Composable
fun ServiceItem(title: String, price: String, iconRes: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(90.dp),
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(containerColor = BlueCard)
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(price, color = Color.White.copy(alpha = 0.9f), fontSize = 14.sp)
            }
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(45.dp),
                tint = Color.Unspecified // Biarkan warna asli icon muncul
            )
        }
    }
}