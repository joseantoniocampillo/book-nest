package com.paudiangui.booknest.data

import com.paudiangui.booknest.utils.cleanHtmlFormat

class BooksRepository {

    suspend fun fetchPopularBooks(): List<Book> =
        BooksClient
            .instance
            .fetchPopularBooks()
            .books
            .map { it.toDomainModel() }

    suspend fun fetchBookById(id: String): Book =
        BooksClient
            .instance
            .fetchBookById(id)
            .toDomainModel()
}

private fun RemoteBook.toDomainModel(): Book =
    Book(
        id = id,
        title = volumeInfo.title,
        author = volumeInfo.authors?.joinToString(", ") ?: "",
        description = cleanHtmlFormat(volumeInfo.description?: "") ,
        cover = volumeInfo.imageLinks?.thumbnail ?: ""
    )