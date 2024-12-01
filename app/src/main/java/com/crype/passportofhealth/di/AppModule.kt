package com.crype.passportofhealth.di

import com.crype.passportofhealth.data.repository.AuthRepositoryImpl
import com.crype.passportofhealth.data.repository.DiseaseRepositoryImpl
import com.crype.passportofhealth.data.repository.HealthIndicatorRepositoryImpl
import com.crype.passportofhealth.data.repository.LifecycleRepositoryImpl
import com.crype.passportofhealth.data.repository.UserRepositoryImpl
import com.crype.passportofhealth.data.repository.VaccinationRepositoryImpl
import com.crype.passportofhealth.domain.repository.AuthRepository
import com.crype.passportofhealth.domain.repository.DiseaseRepository
import com.crype.passportofhealth.domain.repository.HealthIndicatorRepository
import com.crype.passportofhealth.domain.repository.LifecycleRepository
import com.crype.passportofhealth.domain.repository.UserRepository
import com.crype.passportofhealth.domain.repository.VaccinationRepository
import com.crype.passportofhealth.domain.usecase.LoginUserUseCase
import com.crype.passportofhealth.domain.usecase.RegisterUserUseCase
import com.crype.passportofhealth.presantation.viewModel.AuthViewModel
import com.crype.passportofhealth.presantation.viewModel.DiseaseViewModel
import com.crype.passportofhealth.presantation.viewModel.HealthIndicatorViewModel
import com.crype.passportofhealth.presantation.viewModel.LifecycleViewModel
import com.crype.passportofhealth.presantation.viewModel.UserViewModel
import com.crype.passportofhealth.presantation.viewModel.VaccinationViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }

    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    single<DiseaseRepository> { DiseaseRepositoryImpl(get(), get()) }
    single<HealthIndicatorRepository> { HealthIndicatorRepositoryImpl(get(), get()) }
    single<LifecycleRepository> { LifecycleRepositoryImpl(get(), get()) }
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
    single<VaccinationRepository> { VaccinationRepositoryImpl(get(), get()) }

    factory { RegisterUserUseCase(get()) }
    factory { LoginUserUseCase(get()) }

    viewModel { AuthViewModel(get(), get()) }
    viewModel { DiseaseViewModel(get()) }
    viewModel { LifecycleViewModel(get()) }
    viewModel { UserViewModel(get()) }
    viewModel { VaccinationViewModel(get()) }
    viewModel { HealthIndicatorViewModel(get()) }
}