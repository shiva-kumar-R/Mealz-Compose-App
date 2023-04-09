package com.test.mealz.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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
        Row(
            modifier = Modifier.animateContentSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MealImage(meal = meal)
            MealContent(meal = meal)
        }
    }
}

@Composable
fun MealImage(meal: MealsResponse) {
    AsyncImage(
        model = meal.imageUrl,
        contentDescription = null,
        modifier = Modifier
            .size(90.dp)
            .padding(4.dp)
    )
}

@Composable
fun MealContent(meal: MealsResponse) {
    var isExpanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(0.8f)
    ) {
        Text(
            text = meal.name,
            style = MaterialTheme.typography.h6
        )
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = meal.description,
                style = MaterialTheme.typography.subtitle2,
                overflow = TextOverflow.Ellipsis,
                maxLines = if (isExpanded) 10 else 4,
                textAlign = TextAlign.Start
            )
        }
    }
    Icon(
        imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
        contentDescription = null,
        modifier = Modifier
            .clickable { isExpanded = !isExpanded }
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzTheme {
        MealsCategoriesScreen()
    }
}