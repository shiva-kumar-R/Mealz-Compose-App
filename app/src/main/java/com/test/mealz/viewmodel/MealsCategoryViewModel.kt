package com.test.mealz.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.mealz.model.MealsResponse
import com.test.mealz.repository.MealsRepository
import kotlinx.coroutines.launch

class MealsCategoryViewModel(
    private val mealsRepository: MealsRepository
) : ViewModel() {
    private val _mealsData = MutableLiveData<List<MealsResponse>>()

    val mealsData: LiveData<List<MealsResponse>> get() = _mealsData

    fun getMeals() {
        viewModelScope.launch {
            val meals = mealsRepository.getMeals().categories
            _mealsData.postValue(meals)
        }
    }
}