package com.paudiangui.booknest.data

class BooksRepository {

    suspend fun fetchPopularBooks(): List<Book> =
        BooksClient
            .instance
            .fetchPopularBooks()
            .books
            .map { it.toDomainModel() }
}

private fun RemoteBook.toDomainModel(): Book =
    Book(
        id = id,
        title = volumeInfo.title,
        author = volumeInfo.authors?.joinToString(", ") ?: "",
        description = volumeInfo.description ?: "",
        cover = volumeInfo.imageLinks?.thumbnail?.replace("http://", "https://") ?: ""
    )