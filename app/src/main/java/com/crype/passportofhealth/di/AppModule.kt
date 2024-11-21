package com.crype.passportofhealth.di

import com.crype.passportofhealth.presantation.viewModel.HealthIndicatorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HealthIndicatorViewModel() }
}