package com.paudiangui.booknest.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteResult(
    @SerialName("totalItems") val totalItems: Int,
    @SerialName("items") val books: List<RemoteBook>
)

@Serializable
data class RemoteBook(
    val id: String,
    @SerialName("volumeInfo") val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String,
    val authors: List<String>? = null,
    val description: String? = null,
    val pageCount: Int? = null,
    @SerialName("imageLinks") val imageLinks: ImageLinks? = null,
    val language: String,
    val previewLink: String,
    val infoLink: String
)

@Serializable
data class ImageLinks(
    val thumbnail: String? = null
)