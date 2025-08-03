package com.example.myapplication.representation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.remote.models.Result
import com.example.myapplication.representation.components.ShowRow
import com.example.myapplication.representation.components.ShowRowUpcoming

@Composable
fun UpcomingScreen(upcomingMovies: List<Result>){
    LazyColumn(modifier = Modifier
        .background(color = Color.White)
        .padding(10.dp)) {

        item{
            ShowRowUpcoming("upcoming",upcomingMovies)
        }
    }
}