package me.ahch.fleetlist_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.ahch.fleetlist_data.remote.FleetApi
import me.ahch.fleetlist_data.repository.FleetRepositoryImpl
import me.ahch.fleetlist_domain.repository.FleetRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FleetListDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideFleetApi(client: OkHttpClient): FleetApi {
        return Retrofit.Builder()
            .baseUrl(FleetApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create()
    }


    @Provides
    @Singleton
    fun provideFleetRepository(
        api: FleetApi,
    ): FleetRepository {
        return FleetRepositoryImpl(
            api = api
        )
    }
}