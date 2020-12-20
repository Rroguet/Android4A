package com.esiea.android4a.injection

import android.content.Context
import androidx.room.Room
import com.esiea.android4a.data.local.AppDatabase
import com.esiea.android4a.data.local.DatabaseDao
import com.esiea.android4a.data.repository.UserRespository
import com.esiea.android4a.domain.usecase.CreateUserUseCase
import com.esiea.android4a.domain.usecase.GetUserUseCase
import com.esiea.android4a.presentation.main.MainViewModel
import com.esiea.android4a.presentation.register.RegisterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel(get()) }
    factory { RegisterViewModel(get())}
}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {
    single { UserRespository(get()) }
    single { createDatabase(androidContext()) }
}

fun createDatabase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).fallbackToDestructiveMigration().build()
    return appDatabase.databaseDao()
}