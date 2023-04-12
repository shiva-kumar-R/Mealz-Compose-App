package com.test.mealz.ui.screens

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.test.mealz.model.MealsResponse
import com.test.mealz.ui.screens.MealsDetailScreenPictureStatus.Expanded
import com.test.mealz.ui.screens.MealsDetailScreenPictureStatus.Normal

@Composable
fun MealsDetailScreen(meal: MealsResponse?) {
    var profilePictureState by remember { mutableStateOf(Normal) }
    val transition = updateTransition(targetState = profilePictureState, label = "")
    val imageSizeDp by transition.animateDp(targetValueByState = { it.size }, label = "")
    val color by transition.animateColor(targetValueByState = { it.color }, label = "")
    val widthSize by transition.animateDp(targetValueByState = { it.borderWidth }, label = "")

    /**
     * Single animation
     *
     *val imageSizeDp: Dp by animateDpAsState(
     *   targetValue = if (isExpanded) 200.dp else 100.dp
     *)
     */

    Column(modifier = Modifier.padding(8.dp)) {
        Row {
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .size(imageSizeDp),
                shape = CircleShape,
                border = BorderStroke(widthSize, color = color)

            ) {
                AsyncImage(
                    model = meal?.imageUrl,
                    contentDescription = null
                )
            }
            Text(
                text = meal?.name ?: "",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Button(onClick = {
            profilePictureState = if (profilePictureState == Normal) Expanded
                else Normal
        }) {
            Text(text = "Change State of Meal Picture")
        }
    }
}

enum class MealsDetailScreenPictureStatus(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Red, 120.dp, 4.dp),
    Expanded(Color.Black, 200.dp, 8.dp)
}