package com.test.mealz.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.mealz.model.MealsResponse
import com.test.mealz.repository.MealsRepository
import com.test.mealz.ui.model.MealsViewState
import com.test.mealz.utils.Status
import kotlinx.coroutines.launch

class MealsCategoryViewModel(
    private val mealsRepository: MealsRepository
) : ViewModel() {
    private val _viewState = MutableLiveData<MealsViewState>()

    val viewState: LiveData<MealsViewState> get() = _viewState

    companion object {
        private val TAG = MealsCategoryViewModel::class.simpleName
    }

    fun getMeals() {
        viewModelScope.launch {
            try {
                _viewState.value = MealsViewState.LoadingState
                mealsRepository.getMeals().let {
                    when (it.status) {
                        Status.SUCCESS -> _viewState.value =
                            MealsViewState.SuccessState(it.data?.categories.orEmpty())
                        Status.ERROR -> _viewState.value =
                            MealsViewState.ErrorState
                    }
                }
            } catch (e: Exception) {
                Log.w(TAG, e)
                _viewState.value = MealsViewState.ErrorState
            }
        }
    }
}