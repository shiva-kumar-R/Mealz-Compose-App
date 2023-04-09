package com.test.mealz.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.test.mealz.ui.model.MealsViewState
import com.test.mealz.ui.theme.MealzTheme
import com.test.mealz.viewmodel.MealsCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzTheme {
                MealsCategoriesScreen()
            }
        }
    }
}

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoryViewModel = viewModel()

    when (val meals = viewModel.viewState.value) {
        MealsViewState.LoadingState -> Unit
        is MealsViewState.SuccessState -> {
            LazyColumn {
                items(meals.mealsData) { meal ->
                    Text(text = meal.name)
                }
            }
        }
        MealsViewState.ErrorState -> Text(text = "Error")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzTheme {
        MealsCategoriesScreen()
    }
}