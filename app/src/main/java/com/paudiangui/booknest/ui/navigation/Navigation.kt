package com.paudiangui.booknest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.paudiangui.booknest.books
import com.paudiangui.booknest.ui.screens.details.DetailsScreen
import com.paudiangui.booknest.ui.screens.home.HomeScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen(onClick = {book ->
                navController.navigate("details/${book.id}")
            })
        }

        composable(
            "details/{bookId}",
            arguments =  listOf(navArgument("bookId") {type = NavType.StringType})
        ){backStrackEntry ->
            val bookId = backStrackEntry.arguments?.getString("bookId")
            DetailsScreen(
                books.first(),
                onBack = {navController.popBackStack()}
            )
        }
    }

}