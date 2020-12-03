package pr.dwkim.themoviedatabase.repository.remote

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pr.dwkim.themoviedatabase.BuildConfig
import pr.dwkim.themoviedatabase.repository.TmdbApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideApiService(
        @ApplicationContext context: Context
    ): TmdbApiService =
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/4/")
            .client(
                OkHttpClient.Builder().apply {
                    readTimeout(30, TimeUnit.SECONDS)
                    connectTimeout(30, TimeUnit.SECONDS)
                    cache(Cache(context.cacheDir, (10 * 1024 * 1024).toLong()))

//                    addInterceptor { chain ->
//                        chain.proceed(
//                            chain.request()
//                                .newBuilder()
//                                .header("Authorization", "Baerer ${access_token}")
//                                .build()
//                        )
//                    }

                    if(BuildConfig.DEBUG) {
                        addInterceptor(
                            HttpLoggingInterceptor().apply {
                                level = HttpLoggingInterceptor.Level.HEADERS
                                level = HttpLoggingInterceptor.Level.BODY
                            }
                        )
                    }
                }.build())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TmdbApiService::class.java)
}