package com.test.mealz.model

import com.google.gson.annotations.SerializedName

data class MealsCategoryResponse(
    @SerializedName("categories") val categories: List<MealsResponse>
)

data class MealsResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val category: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)