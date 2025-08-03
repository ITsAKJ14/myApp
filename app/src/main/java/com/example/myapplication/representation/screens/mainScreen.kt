package com.example.myapplication.representation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.models.Dest
import com.example.myapplication.models.NavigationGraph
import com.example.myapplication.remote.models.Result

@Composable
fun MainScreen(resultUpcoming: List<Result>, resultPopular: List<Result>) {
    val navController = rememberNavController()
    val items = listOf(
        Dest.Popular,
        Dest.Upcoming
    )
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        icon = {
                            Icon(
                                painter = painterResource(id = if (currentRoute == item.route) item.selectedIcon else item.unselectedIcon),
                                contentDescription = item.route,
                                modifier = Modifier.size(28.dp),

                                )
                        },
                        onClick = {
                            if (currentRoute != item.route) {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }


                        }
                    )
                }
            }
        }


    ) { innerPadding ->
        NavigationGraph(navController = navController, resultPopular = resultPopular,
            resultUpcoming = resultUpcoming)

    }


}