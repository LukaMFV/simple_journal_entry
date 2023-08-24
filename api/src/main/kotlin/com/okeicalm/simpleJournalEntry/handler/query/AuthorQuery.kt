package com.okeicalm.simpleJournalEntry.handler.query

import com.expediagroup.graphql.server.operations.Query
import com.okeicalm.simpleJournalEntry.handler.type.AccountType
import com.okeicalm.simpleJournalEntry.handler.type.AuthorType
import com.okeicalm.simpleJournalEntry.repository.AccountRepository
import com.okeicalm.simpleJournalEntry.repository.AuthorRepository
import org.springframework.stereotype.Component

@Component
class AuthorQuery(private val repository: AuthorRepository) : Query {
    fun allAuthors(): List<AuthorType> {
        return repository.findAll().map { AuthorType(it) }
    }

    fun searchByName(name: String): List<AuthorType> {
        return repository.searchByName(name).map { AuthorType(it) }
    }

}
