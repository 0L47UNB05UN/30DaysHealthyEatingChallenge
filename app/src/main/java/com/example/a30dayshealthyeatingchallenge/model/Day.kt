package com.example.a30dayshealthyeatingchallenge.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day(
    @StringRes val desc: Int,
    @StringRes val tip: Int,
    @DrawableRes val img: Int
)
