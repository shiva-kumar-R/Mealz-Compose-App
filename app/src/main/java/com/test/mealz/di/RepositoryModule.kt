package com.test.mealz.di

import com.test.mealz.repository.MealsRepository
import com.test.mealz.repository.MealsRepositoryImpl
import com.test.mealz.service.MealsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMealsRepository(mealsApiService: MealsApiService): MealsRepository =
        MealsRepositoryImpl(mealsApiService)
}