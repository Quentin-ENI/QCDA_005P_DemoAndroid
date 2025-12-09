package com.example.module06demo02.db

import android.provider.BaseColumns

object BookContract {
    val TABLE_NAME = "books"

    val COLUMN_NAME = "name"
    val COLUMN_ISBN = "isbn"
    val COLUMN_EDITOR = "editor"
    val COLUMN_AUTHOR = "author"

    val DATABASE_VERSION = 1
    val DATABASE_NAME = "BookStore.db"

    val SQL_CREATE_ENTRIES = """
        CREATE TABLE $TABLE_NAME(
            ${BaseColumns._ID} INTEGER PRIMARY KEY,
            $COLUMN_NAME TEXT,
            $COLUMN_ISBN TEXT,
            $COLUMN_EDITOR TEXT,
            $COLUMN_AUTHOR TEXT
        )
    """

    val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"
}