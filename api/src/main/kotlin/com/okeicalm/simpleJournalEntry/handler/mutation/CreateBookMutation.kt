package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.BookType
import com.okeicalm.simpleJournalEntry.usecase.book.BookCreateUseCase
import com.okeicalm.simpleJournalEntry.usecase.book.BookCreateUseCaseInput
import org.springframework.stereotype.Component

data class CreateBookInput(val name: String, val authorId: ID, val description: String)

@Component
class CreateBookMutation(private val bookCreateUseCase: BookCreateUseCase) : Mutation {
    fun createBook(input: CreateBookInput): BookType {
        val output = bookCreateUseCase.call(
            BookCreateUseCaseInput(
                name = input.name,
                authorId = input.authorId.toString().toLong(),
                description = input.description,
            )
        )
        return BookType(output.book)
    }
}
