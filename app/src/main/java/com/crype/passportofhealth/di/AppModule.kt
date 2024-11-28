package com.crype.passportofhealth.di

import com.crype.passportofhealth.data.repository.AuthRepositoryImpl
import com.crype.passportofhealth.domain.repository.AuthRepository
import com.crype.passportofhealth.domain.usecase.LoginUserUseCase
import com.crype.passportofhealth.domain.usecase.RegisterUserUseCase
import com.crype.passportofhealth.presantation.viewModel.AuthViewModel
import com.crype.passportofhealth.presantation.viewModel.HealthIndicatorViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HealthIndicatorViewModel() }
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    factory { RegisterUserUseCase(get()) }
    factory { LoginUserUseCase(get()) }
    viewModel { AuthViewModel(get(), get()) }
}