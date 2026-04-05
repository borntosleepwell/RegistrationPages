package com.cobacoba.testpages

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val nama : String,
    val nim : String,
    val prodi : String,
    val jenisKelamin : String,
    val hobi : String
) : Parcelable
