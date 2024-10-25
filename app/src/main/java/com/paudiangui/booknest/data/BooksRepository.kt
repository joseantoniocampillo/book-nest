package com.paudiangui.booknest.data

import kotlinx.coroutines.delay

class BooksRepository {

    suspend fun fetchPopularBooks(): List<Book> {
        delay(2000)
        return books
    }

}