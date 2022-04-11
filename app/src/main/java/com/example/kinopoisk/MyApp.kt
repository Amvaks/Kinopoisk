package com.example.kinopoisk

import android.app.Application
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MyApp: Application() {
    lateinit var previewApi: PreviewApi
    lateinit var previewApi2: PreviewApi
    lateinit var previewApi3: PreviewApi
    lateinit var previewApi4: PreviewApi

    override fun onCreate() {
        super.onCreate()

        configureRetrofit()
    }

    private fun configureRetrofit() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://kinopoiskapiunofficial.tech")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        previewApi = retrofit.create(PreviewApi::class.java)

        previewApi2 = retrofit.create(PreviewApi2::class.java)

        previewApi3 = retrofit.create(PreviewApi3::class.java)

        previewApi4 = retrofit.create(PreviewApi4::class.java)
        //Log.i("test", "MyApp211")
    }
}