package com.test.mealz.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.test.mealz.ui.screens.MealsCategoriesScreen
import com.test.mealz.ui.screens.MealsDetailScreen
import com.test.mealz.ui.theme.MealzTheme
import com.test.mealz.viewmodel.MealDetailsViewModel
import com.test.mealz.viewmodel.MealsCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzTheme {
                FoodiezApp()
            }
        }
    }
}

@Composable
private fun FoodiezApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "destination_meals_list") {
        composable(route = "destination_meals_list") {
            val viewModel: MealsCategoryViewModel = hiltViewModel()
            MealsCategoriesScreen(viewModel.viewState.value) { mealId ->
                navController.navigate("destination_meal_details/$mealId")
            }
        }
        composable(
            route = "destination_meal_details/{mealId}",
            arguments = listOf(navArgument(name = "mealId") {
                type = NavType.StringType
            })
        ) {
            val viewModel: MealDetailsViewModel = hiltViewModel()
            MealsDetailScreen(meal = viewModel.mealState.value)
        }
    }
}
