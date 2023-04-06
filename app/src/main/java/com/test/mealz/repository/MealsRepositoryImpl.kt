package com.test.mealz.repository

import com.test.mealz.model.MealsCategoryResponse

class MealsRepositoryImpl(): MealsRepository {

    override suspend fun getMeals(): MealsCategoryResponse = MealsCategoryResponse(arrayListOf())
}