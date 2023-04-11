package com.test.mealz.repository

import com.test.mealz.model.MealsCategoryResponse
import com.test.mealz.model.MealsResponse
import com.test.mealz.utils.Resource

interface MealsRepository {
    suspend fun getMeals(): Resource<MealsCategoryResponse?>

    fun getMeal(mealId: String): MealsResponse?
}