package my.android.svgassignment.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import my.android.svgassignment.data.remote.DogApiService
import my.android.svgassignment.data.repository.DogRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): DogApiService{
        return retrofit.create(DogApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("DogCache", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideDogRepository(
        dogApiService: DogApiService,
        sharedPreferences: SharedPreferences
    ): DogRepository {
        return DogRepository(dogApiService, sharedPreferences)
    }
}