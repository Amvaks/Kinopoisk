package com.example.kinopoisk

data class PreviewList(val pagesCount: Int, val films: List<PreviewListItem>)

data class PreviewListItem(
    val filmId: Int? = null,
    val nameRu: String? = null,
    val nameEn: String? = null,
    val year: String? = null,
    val filmLength: String? = null,
    val countries: List<ListAttributes>? = null,
    val genres: List<ListAttributes>? = null,
    val rating: String? = null,
    val ratingVoteCount: Int? = null,
    val posterUrl: String? = null,
    val posterUrlPreview: String? = null,
    val ratingChange: String? = null
)

data class ListAttributes(val type: String?, val Content: String?)