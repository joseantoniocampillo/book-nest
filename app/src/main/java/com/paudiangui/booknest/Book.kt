package com.paudiangui.booknest

data class Book (
    val id: Int,
    val title: String,
    val author: String,
    val cover: String
)

val books = (1..100).map {
    Book(
        id = it,
        title = "Movie $it",
        author = "Author $it",
        cover = "https://picsum.photos/200/300?id=$it"
    )
}