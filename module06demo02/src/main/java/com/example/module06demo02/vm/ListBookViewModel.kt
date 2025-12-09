package com.example.module06demo02.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.module06demo02.bo.Book
import com.example.module06demo02.dao.BookDao
import com.example.module06demo02.db.BookDbHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ListBookViewModel(val bookDbHelper: BookDbHelper): ViewModel() {
    private val dao = BookDao(
        bookDbHelper.writableDatabase,
        bookDbHelper.readableDatabase
    )

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books = _books

    init {
        insertBook(
            Book(
                0L,
                "Dune",
                "ISBN-DUNE",
                "L'éditeur de Dune",
                "Frank Herbert"
            )
        )
        insertBook(
            Book(
                0L,
                "La route",
                "IBSEN-LA-ROUTE",
                "L'éditeur de la route",
                "Cormac MacCarthy"
            )
        )
        loadBooks()
    }

    private fun insertBook(book: Book) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertBook(book);
        }
    }

    private fun loadBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            _books.value = dao.findAll()
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                return ListBookViewModel(
                    BookDbHelper(application.applicationContext)
                ) as T
            }
        }
    }
}