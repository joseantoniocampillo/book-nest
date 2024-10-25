package com.paudiangui.booknest.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paudiangui.booknest.data.Book
import com.paudiangui.booknest.data.BooksRepository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val repository = BooksRepository()

    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(loading = false, books = repository.fetchPopularBooks())
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val books: List <Book> = emptyList()
    )
}