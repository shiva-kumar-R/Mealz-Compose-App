package com.test.mealz.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.test.mealz.model.MealsResponse

@Composable
fun MealsDetailScreen(meal: MealsResponse?) {
    Column {
        Row {
            Card {
                AsyncImage(
                    model = meal?.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(200.dp)
                )
            }
            Text(text = meal?.name ?: "")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Change State of Meal Picture")
        }
    }
}