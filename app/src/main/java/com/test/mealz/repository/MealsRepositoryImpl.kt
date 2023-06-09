package com.test.mealz.repository

import android.util.Log
import com.test.mealz.model.MealsResponse
import com.test.mealz.service.MealsApiService
import com.test.mealz.utils.Resource
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val mealsApiService: MealsApiService
) : MealsRepository {

    private var cachedMeals = listOf<MealsResponse>()

    companion object {
        private val TAG = MealsRepositoryImpl::class.simpleName
    }

    override suspend fun getMeals() = try {
        val response = mealsApiService.getMeals()
        if (response.isSuccessful && response.body() != null) {
            cachedMeals = response.body()?.categories.orEmpty()
            Resource.success(data = response.body())
        } else {
            Resource.error(message = "Code: ${response.code()} , Message: ${response.raw()}")
        }
    } catch (e: Exception) {
        Log.w(TAG, e)
        throw Exception(e.message)
    }

    override fun getMeal(mealId: String) = cachedMeals.firstOrNull {
        it.id == mealId
    }
}