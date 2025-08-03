package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.remote.API_KEY
import com.example.myapplication.remote.CATEGORY_POPULAR
import com.example.myapplication.remote.CATEGORY_UPCOMING
import com.example.myapplication.remote.TmdbApiImp
import com.example.myapplication.remote.models.Result
import com.example.myapplication.representation.screens.MainScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val resultPopular = remember { mutableStateListOf<Result>() }
            val resultUpcoming = remember { mutableStateListOf<Result>() }
            var isLoading by remember { mutableStateOf(true) }

            LaunchedEffect(Unit) {
                try {
                    val response = TmdbApiImp.getInstance()
                    val responsePopular = response.getMovieInfo(CATEGORY_POPULAR, API_KEY)
                    val responseUpcoming = response.getMovieInfo(CATEGORY_UPCOMING, API_KEY)

                    if (responsePopular.isSuccessful) {
                        responsePopular.body()?.results?.let {
                            resultPopular.clear()
                            resultPopular.addAll(it)
                        }
                    }

                    if (responseUpcoming.isSuccessful) {
                        responseUpcoming.body()?.results?.let {
                            resultUpcoming.clear()
                            resultUpcoming.addAll(it)
                        }
                    }

                } catch (e: Exception) {
                    Log.e("DEBUG", "Network call failed: ${e.message}")
                }
            }

            MyApplicationTheme {
                Log.d("DEBUG", "Popular size = ${resultPopular.size}")
                Log.d("DEBUG", "Upcoming size = ${resultUpcoming.size}")


                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    if (isLoading) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    } else {
                        MainScreen(resultPopular, resultUpcoming)
                    }
                }
            }
        }
    }
}
