package com.test.mealz.ui.model

import com.test.mealz.model.MealsResponse

sealed class MealsViewState() {
    object LoadingState: MealsViewState()

    data class SuccessState(
        val mealsData: List<MealsResponse>
    ): MealsViewState()

    object ErrorState: MealsViewState()
}