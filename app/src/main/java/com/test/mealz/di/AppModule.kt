package com.test.mealz.di

import com.test.mealz.repository.MealsRepository
import com.test.mealz.repository.MealsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindMealsRepository(mealsRepositoryImpl: MealsRepositoryImpl): MealsRepository
}