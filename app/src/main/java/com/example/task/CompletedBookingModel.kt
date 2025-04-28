package com.example.task

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class CompletedBookingModel(
    val artistName: String,
    val artistId: String,
    val date: String,
    val style: String,
    val rating: Float,
    val price: String,
    val status: String,
    val statusColor: Int,
    @DrawableRes
    val artistImage: Int
)

