package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.AuthorType
import com.okeicalm.simpleJournalEntry.usecase.author.AuthorCreateUseCase
import com.okeicalm.simpleJournalEntry.usecase.author.AuthorCreateUseCaseInput
import org.springframework.stereotype.Component

data class CreateAuthorInput(val name: String, val age: Int, val address: String)

@Component
class CreateAuthorMutation(private val authorCreateUseCase: AuthorCreateUseCase) : Mutation {
    fun createAuthor(input: CreateAuthorInput): AuthorType {
        val output = authorCreateUseCase.call(
            AuthorCreateUseCaseInput(
                age = input.age,
                name = input.name,
                address = input.address,
            )
        )
        return AuthorType(output.author)
    }
}
