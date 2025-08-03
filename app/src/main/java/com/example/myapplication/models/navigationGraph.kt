package com.example.myapplication.models

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.remote.models.Result
import com.example.myapplication.representation.screens.PopularScreen
import com.example.myapplication.representation.screens.UpcomingScreen


@Composable
fun NavigationGraph(
    navController: NavHostController,
    resultPopular: List<Result>,
    resultUpcoming: List<Result>){

    NavHost(navController = navController, startDestination = Dest.Popular.route){
        composable(Dest.Popular.route){PopularScreen(resultPopular)}
        composable(Dest.Upcoming.route){UpcomingScreen(resultUpcoming)}
    }

}