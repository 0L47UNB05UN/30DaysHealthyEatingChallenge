package com.example.a30dayshealthyeatingchallenge.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.util.UUID


data class Day(
    @StringRes val desc: Int,
    @StringRes val tip: Int,
    @DrawableRes val img: Int,
    val id: String = UUID.randomUUID().toString()
)
