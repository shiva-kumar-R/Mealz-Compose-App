package com.test.mealz.ui.screens

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
fun MealsDetailScreenWithLazyColumn(meal: MealsResponse?) {
    val scrollState = rememberLazyListState()
    val offset = min(
        1f,
        1 - (scrollState.firstVisibleItemScrollOffset / 600f + scrollState.firstVisibleItemIndex)
    )
    val size by animateDpAsState(targetValue = max(100.dp, 200.dp * offset))

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
            val listData = (0..100).map { it.toString() }
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                state = scrollState
            ) {
                items(listData) {
                    Text(
                        text = it,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}