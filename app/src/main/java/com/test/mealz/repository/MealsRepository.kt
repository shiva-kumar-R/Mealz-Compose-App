package com.test.mealz.repository

import com.test.mealz.model.MealsCategoryResponse

interface MealsRepository {
    suspend fun getMeals(): MealsCategoryResponse
}