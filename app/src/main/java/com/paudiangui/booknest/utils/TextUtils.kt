package com.paudiangui.booknest.utils

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

fun cleanHtmlFormat(description: String): String {
    val document: Document = Jsoup.parse(description)
    return document.text()
}