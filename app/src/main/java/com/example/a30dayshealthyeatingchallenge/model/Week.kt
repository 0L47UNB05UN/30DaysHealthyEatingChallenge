package com.example.a30dayshealthyeatingchallenge.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Week(
    @StringRes val name: Int,
    @StringRes val desc: Int,
    @DrawableRes val img: Int,
    private val theList: List<Day> = listOf()
){
    fun addDays(theDays: List<Day>): Week{
        theList.plus(theDays)
        return Week(name, desc, img, theList)
    }

    fun loadDays(): List<Day>{
        return theList
    }
}
