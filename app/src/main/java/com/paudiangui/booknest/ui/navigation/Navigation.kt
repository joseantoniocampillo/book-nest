package com.paudiangui.booknest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.paudiangui.booknest.ui.screens.details.DetailsScreen
import com.paudiangui.booknest.ui.screens.details.DetailsViewModel
import com.paudiangui.booknest.ui.screens.home.HomeScreen
import kotlinx.serialization.Serializable


@Serializable
object Home

@Serializable
data class Details(val bookId: String)

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home){
        composable<Home>{
            HomeScreen(onClick = {book ->
                navController.navigate(Details(book.id))
            })
        }

        composable<Details> { backStackEntry ->
            val details = backStackEntry.toRoute<Details>()
            DetailsScreen(
                viewModel { DetailsViewModel(details.bookId) },
                onBack = {navController.popBackStack()}
            )
        }
    }

}