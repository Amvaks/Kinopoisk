package com.example.kinopoisk

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface PreviewApi {
    @Headers("accept: application/json", "X-API-KEY: 8ddfc879-fbcf-48df-81d7-f5cc554c70ee")
    @GET("/api/v2.2/films/top?type=TOP_250_BEST_FILMS&page=1")
    fun getPreviewList(): Single<PreviewList>
}

interface PreviewApi2 : PreviewApi {
    @Headers("accept: application/json", "X-API-KEY: 8ddfc879-fbcf-48df-81d7-f5cc554c70ee")
    @GET("/api/v2.2/films/top?type=TOP_250_BEST_FILMS&page=2")
    override fun getPreviewList(): Single<PreviewList>
}

interface PreviewApi3 : PreviewApi {
    @Headers("accept: application/json", "X-API-KEY: 8ddfc879-fbcf-48df-81d7-f5cc554c70ee")
    @GET("/api/v2.2/films/top?type=TOP_250_BEST_FILMS&page=3")
    override fun getPreviewList(): Single<PreviewList>
}

interface PreviewApi4 : PreviewApi {
    @Headers("accept: application/json", "X-API-KEY: 8ddfc879-fbcf-48df-81d7-f5cc554c70ee")
    @GET("/api/v2.2/films/top?type=TOP_250_BEST_FILMS&page=4")
    override fun getPreviewList(): Single<PreviewList>
}