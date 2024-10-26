package com.paudiangui.booknest.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksService {

    @GET ("v1/volumes")
    suspend fun fetchPopularBooks(
        @Query("filter") filter: String = "ebooks",
        @Query("maxResults") maxResults: Int = 40,
        @Query("orderBy") orderBy: String = "relevance",
        @Query("q") query: String = "a"
    ): RemoteResult

    @GET ("v1/volumes/{volumeId}")
    suspend fun fetchBookById(@Path("volumeId") id: String): RemoteBook

}