package com.example.sundmadnepal.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class HealthInfo(
    @DrawableRes val comic: Int,
    @StringRes val comicText: Int,
    @IntegerRes val fromAge: Int,
    @IntegerRes val toAge: Int
)