package com.example.hh

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Job(
    val title: String,
    val company: String,
    val salary: String,
    val location: String
) : Parcelable
