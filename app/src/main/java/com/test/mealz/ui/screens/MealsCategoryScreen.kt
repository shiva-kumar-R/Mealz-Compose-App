package com.test.mealz.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.test.mealz.model.MealsResponse
import com.test.mealz.ui.model.MealsViewState
import com.test.mealz.ui.theme.MealzTheme
import com.test.mealz.viewmodel.MealsCategoryViewModel


@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoryViewModel = viewModel()

    when (val meals = viewModel.viewState.value) {
        MealsViewState.LoadingState -> Unit
        is MealsViewState.SuccessState -> {
            MealsContainer(meals = meals.mealsData)
        }
        MealsViewState.ErrorState -> Text(text = "Error")
    }
}

@Composable
fun MealsContainer(meals: List<MealsResponse>) {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(meals) { meal ->
            MealCategory(meal = meal)
        }
    }
}

@Composable
fun MealCategory(meal: MealsResponse) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row {
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .padding(4.dp)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzTheme {
        MealsCategoriesScreen()
    }
}