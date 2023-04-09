# Mealz Application

This is a sample meals android application developed in Jetpack Compose.

## Features

- Application is build using Kotlin.
- Built in MVVM/MVI clean architecture.
- Database is an open source mealDB. The list of categories API is used to fetch all data.
  Add meals category API. Link to the [database](https://www.themealdb.com/api.php)
- Hilt Dependency Injection.
- Retofit is used to make network calls.
- Coil Library for Image Loading.

## Additional Gradle Dependencies needed

- Add compose viewmodel dependendency. 
`implementation 'androidx.lifecycle:lifecycle-viewmodel-compose:<latest-version>'`

- Add retrofit dependency.
``` 
implementation "com.google.code.gson:gson:<latest-version>"
implementation "com.squareup.retrofit2:retrofit:<latest-version>"
implementation "com.squareup.retrofit2:converter-gson:<latest-version>"
implementation "com.squareup.retrofit2:converter-scalars:<latest-version>" 
```

- Add hilt dependency.
```  
implementation "com.google.dagger:hilt-android:<latest-version>"
kapt "com.google.dagger:hilt-android-compiler:<latest-version>"
implementation "androidx.hilt:hilt-navigation-fragment:<latest-version>"
```

- Add coil dependency.
`implementation "io.coil-kt:coil-compose:<latest-version>"`