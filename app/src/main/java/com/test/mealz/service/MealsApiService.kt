package com.test.mealz.service

import com.test.mealz.model.MealsCategoryResponse
import retrofit2.Response
import retrofit2.http.GET

interface MealsApiService {

    @GET("categories.php")
    suspend fun getMeals(): Response<MealsCategoryResponse?>
}