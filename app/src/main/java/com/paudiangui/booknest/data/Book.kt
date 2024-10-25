package com.paudiangui.booknest.data

data class Book (
    val id: String,
    val title: String,
    val author: String,
    val description: String,
    val cover: String

)

val books = (1..100).map {
    Book(
        id = it.toString(),
        title = "Movie $it",
        author = "Author $it",
        description = "En esta fascinante obra, el autor explora los límites de la imaginación humana, llevándonos a un viaje lleno de misterios y descubrimientos. A través de una narrativa envolvente y personajes profundamente humanos, el libro invita al lector a cuestionar su propia realidad y sumergirse en un mundo de posibilidades infinitas. Con giros inesperados y una prosa cautivadora, esta historia es un reflejo de la búsqueda de significado y pertenencia que todos compartimos. Perfecto para quienes disfrutan de la aventura y el pensamiento introspectivo.",
        cover = "https://picsum.photos/200/300?id=$it"
    )
}