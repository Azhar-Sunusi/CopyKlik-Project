package com.example.projek_pbb_infinity.data.remote.dto

import com.google.firebase.firestore.FirebaseFirestore
import com.example.projek_pbb_infinity.domain.model.Produk

class FirebaseHelper {
    private val db = FirebaseFirestore.getInstance()

    fun tambahProduk(produk: Produk, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        db.collection("produk")
            .add(produk)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { e -> onFailure(e) }
    }
}