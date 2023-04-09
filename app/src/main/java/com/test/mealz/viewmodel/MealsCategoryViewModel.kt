package com.test.mealz.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.mealz.repository.MealsRepository
import com.test.mealz.ui.model.MealsViewState
import com.test.mealz.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsCategoryViewModel @Inject constructor(
    private val mealsRepository: MealsRepository
) : ViewModel() {
    private val _viewState: MutableState<MealsViewState> = mutableStateOf(MealsViewState.LoadingState)

    val viewState: State<MealsViewState> get() = _viewState

    companion object {
        private val TAG = MealsCategoryViewModel::class.simpleName
    }

    init {
        getMeals()
    }

    private fun getMeals() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                mealsRepository.getMeals().let {
                    when (it.status) {
                        Status.SUCCESS -> _viewState.value = MealsViewState.SuccessState(it.data?.categories.orEmpty())
                        Status.ERROR -> {
                            Log.w(TAG, "Error:" + it.message)
                            _viewState.value = MealsViewState.ErrorState
                        }
                    }
                }
            } catch (e: Exception) {
                Log.w(TAG, e)
                _viewState.value = MealsViewState.ErrorState
            }
        }
    }
}