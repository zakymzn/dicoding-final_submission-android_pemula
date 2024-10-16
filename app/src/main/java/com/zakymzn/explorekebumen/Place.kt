package com.zakymzn.explorekebumen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place(
    val name: String,
    val location: String,
    val photo: Int,
    val description: String
) : Parcelable