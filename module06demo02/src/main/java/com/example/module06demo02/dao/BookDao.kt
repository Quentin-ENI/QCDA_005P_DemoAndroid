package com.example.module06demo02.dao

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import com.example.module06demo02.bo.Book
import com.example.module06demo02.db.BookContract

class BookDao(val dbWriter: SQLiteDatabase, val dbReader: SQLiteDatabase) {
    fun insertBook(book: Book): Boolean {
        val values = ContentValues().apply {
            put(BookContract.COLUMN_NAME, book.name)
            put(BookContract.COLUMN_ISBN, book.isbn)
            put(BookContract.COLUMN_EDITOR, book.editor)
            put(BookContract.COLUMN_AUTHOR, book.author)
        }

        val newRowId = dbWriter.insert(BookContract.TABLE_NAME, null, values)
        return newRowId != -1L
    }

    fun findAll(): List<Book> {
        val projection = arrayOf(
            BaseColumns._ID,
            BookContract.COLUMN_NAME,
            BookContract.COLUMN_ISBN,
            BookContract.COLUMN_EDITOR,
            BookContract.COLUMN_AUTHOR
        )

        val cursor = dbReader.query(
            BookContract.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        val bookList = mutableListOf<Book>()

        with(cursor) {
            while (moveToNext()) {
                val book = Book(
                    id = getLong(getColumnIndexOrThrow(BaseColumns._ID)),
                    name = getString(getColumnIndexOrThrow(BookContract.COLUMN_NAME)),
                    isbn = getString(getColumnIndexOrThrow(BookContract.COLUMN_ISBN)),
                    editor = getString(getColumnIndexOrThrow(BookContract.COLUMN_EDITOR)),
                    author = getString(getColumnIndexOrThrow(BookContract.COLUMN_AUTHOR)),
                )
                bookList += book
            }
        }
        cursor.close()

        return bookList
    }
}