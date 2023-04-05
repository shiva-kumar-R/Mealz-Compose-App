package com.test.mealz.viewmodel

import androidx.lifecycle.ViewModel
import com.test.mealz.model.MealsRepository

class MealsCategoryViewModel(
    private val mealsRepository: MealsRepository = MealsRepository()
) : ViewModel() {

}