package com.zakymzn.explorekebumen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlaceDetail(
    val name: String,
    val location: String,
    val description: String,
    val photo: Int
) : Parcelable