package com.test.mealz.ui.screens

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.AsyncImage
import com.test.mealz.model.MealsResponse
import com.test.mealz.ui.screens.MealsDetailScreenPictureStatus.Expanded
import com.test.mealz.ui.screens.MealsDetailScreenPictureStatus.Normal
import kotlin.math.min

@Composable
fun MealsDetailScreenWithCollapsableBar(meal: MealsResponse?) {
    val scrollState = rememberScrollState()
    val offset = min(1f, 1 - (scrollState.value / 600f))
    val size by animateDpAsState(targetValue =  max(100.dp, 200.dp * offset))

    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(8.dp)) {
            Surface(elevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(size),
                        shape = CircleShape,
                        border = BorderStroke(5.dp, color = Color.Red)
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
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
            ) {
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
                Text(text = "Sample Text", modifier = Modifier.padding(20.dp))
            }
        }
    }
}