package com.okeicalm.simpleJournalEntry.entity

data class Book(
    val id: Long = 0,
    val name: String,
    val authorId: Long,
    val description: String
)