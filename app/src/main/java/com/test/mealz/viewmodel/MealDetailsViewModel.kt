package com.test.mealz.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.test.mealz.model.MealsResponse
import com.test.mealz.repository.MealsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val mealsRepository: MealsRepository
) : ViewModel() {
    private val _mealState: MutableState<MealsResponse?> = mutableStateOf(null)

    val mealState: State<MealsResponse?> get() = _mealState

    init {
        val mealId = savedStateHandle.get<String>("mealId") ?: ""
        _mealState.value = mealsRepository.getMeal(mealId)
    }
}