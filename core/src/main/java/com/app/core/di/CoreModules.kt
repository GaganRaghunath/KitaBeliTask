package com.app.core.di

import com.app.core.usecase.OrderHistoryInteractor
import com.app.core.usecase.OrderHistoryPagingInteractor
import com.app.core.usecase.OrderHistoryPagingUseCase
import com.app.core.usecase.OrderHistoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class CoreModules {

  @Provides
  @ViewModelScoped
  fun provideOrderHistoryInteractor(interactor: OrderHistoryInteractor): OrderHistoryUseCase {
    return interactor
  }

  @Provides
  @ViewModelScoped
  fun provideOrderHistoryPagingInteractor(interactor: OrderHistoryPagingInteractor): OrderHistoryPagingUseCase {
    return interactor
  }
}