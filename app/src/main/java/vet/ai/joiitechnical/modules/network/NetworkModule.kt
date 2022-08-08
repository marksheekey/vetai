package vet.ai.joiitechnical.modules.network

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Cache
import okhttp3.OkHttpClient
import vet.ai.joiitechnical.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.File
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    //very generic gson factory here, but can be used for more specific naming schemas, or create a moshi adapter
    @Provides
    @Singleton
    fun provideGson() = GsonBuilder().create()

    //cache for performance improves with okhttp to cache responses and return 304s for a not-changed response
    @Provides
    @Singleton
    fun provideCacheDir(@ApplicationContext context: Context): Cache {
        return Cache(File(context.cacheDir, "pokemon"), (10 * 1024 * 1024).toLong())
    }

    @Provides
    @Singleton
    fun provideHttpClient(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder().run {
                    addHeader("Content-Type", "application/json")
                }.build()

                chain.proceed(newRequest)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson) = GsonConverterFactory.create(gson)


    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonAPI(retrofit: Retrofit): PokemonAPI = retrofit.create()
}