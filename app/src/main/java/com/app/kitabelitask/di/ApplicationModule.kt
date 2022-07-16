package com.app.kitabelitask.di

import android.content.Context
import com.app.core.DB_NAME
import com.app.core.data.local.LocalDataSource
import com.app.core.data.local.LocalDataSourceImpl
import com.app.core.data.local.db.RoomDB
import com.app.core.data.preference.PreferenceHelper
import com.app.core.data.preference.PreferenceManager
import com.app.core.data.remote.ApiDataSource
import com.app.core.data.remote.ApiDataSourceImpl
import com.app.core.data.remote.service.RetrofitService
import com.app.kitabelitask.BuildConfig
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

  @Provides
  @Singleton
  fun provideRoomDB(
    @Named("dataBaseName") dbName: String, @ApplicationContext context: Context
  ): RoomDB {
    return RoomDB.getDatabase(context, dbName)
  }

  @Provides
  @Named("dataBaseName")
  fun provideDatabaseName(): String {
    return DB_NAME
  }

  @Provides
  @Singleton
  fun provideLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource {
    return localDataSourceImpl
  }

  @Provides
  @Singleton
  fun providePreferencesHelper(preferenceManager: PreferenceManager): PreferenceHelper {
    return preferenceManager
  }

  @Provides
  @Singleton
  fun provideApiDataSource(apiDataSourceImpl: ApiDataSourceImpl): ApiDataSource {
    return apiDataSourceImpl
  }

  @Provides
  @Singleton
  fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().build()
  }

  @Provides
  @Singleton
  fun provideApiService(okHttpClient: OkHttpClient): RetrofitService {
    return Retrofit
      .Builder()
      .baseUrl(BuildConfig.BASE_URL)
      .client(okHttpClient)
      .addConverterFactory(GsonConverterFactory.create(Gson()))
      .build()
      .create(RetrofitService::class.java)
  }
}