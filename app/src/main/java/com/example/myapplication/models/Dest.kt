package com.example.myapplication.models

import com.example.myapplication.R

sealed class Dest(
    val route: String, val selectedIcon: Int, val unselectedIcon: Int

) {
     object Popular :
        Dest("popular", R.drawable.popular_selected, R.drawable.popular_unselected)

     object Upcoming :
        Dest("upcoming", R.drawable.upcoming_selected, R.drawable.upcoming_unselected)
}