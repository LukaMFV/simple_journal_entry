package com.okeicalm.simpleJournalEntry.handler.query

import com.expediagroup.graphql.server.operations.Query
import com.okeicalm.simpleJournalEntry.handler.type.AccountType
import com.okeicalm.simpleJournalEntry.handler.type.AuthorType
import com.okeicalm.simpleJournalEntry.handler.type.BookType
import com.okeicalm.simpleJournalEntry.repository.AccountRepository
import com.okeicalm.simpleJournalEntry.repository.AuthorRepository
import com.okeicalm.simpleJournalEntry.repository.BookRepository
import org.springframework.stereotype.Component

@Component
class BookQuery(private val repository: BookRepository) : Query {
    fun allBooks(): List<BookType> {
        return repository.findAll().map { BookType(it) }
    }
}
