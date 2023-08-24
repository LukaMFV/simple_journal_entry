package com.okeicalm.simpleJournalEntry.usecase.author

import com.okeicalm.simpleJournalEntry.entity.Author
import com.okeicalm.simpleJournalEntry.repository.AuthorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

data class AuthorCreateUseCaseInput(val name: String, val age: Int, val address: String)
data class AuthorCreateUseCaseOutput(val author: Author)

interface AuthorCreateUseCase {
    fun call(input: AuthorCreateUseCaseInput): AuthorCreateUseCaseOutput
}

@Service
class AuthorCreateUseCaseImpl(private val authorRepository: AuthorRepository) : AuthorCreateUseCase {
    @Transactional
    override fun call(input: AuthorCreateUseCaseInput): AuthorCreateUseCaseOutput {
        val author = Author(
            name = input.name,
            age = input.age,
            address = input.address,
            bookList = listOf()
        )
        return AuthorCreateUseCaseOutput(authorRepository.create(author))
    }
}
