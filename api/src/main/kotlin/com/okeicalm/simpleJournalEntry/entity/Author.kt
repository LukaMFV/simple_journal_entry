package com.okeicalm.simpleJournalEntry.entity

data class Author(
    val id: Long = 0,
    val age: Int,
    val name: String,
    val address: String,
    val bookList: List<Book>
)
