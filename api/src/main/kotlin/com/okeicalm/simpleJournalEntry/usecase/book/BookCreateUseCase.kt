package com.okeicalm.simpleJournalEntry.usecase.book

import com.okeicalm.simpleJournalEntry.entity.Author
import com.okeicalm.simpleJournalEntry.entity.Book
import com.okeicalm.simpleJournalEntry.repository.BookRepository
import com.okeicalm.simpleJournalEntry.usecase.author.AuthorCreateUseCaseOutput
import org.springframework.stereotype.Service

data class BookCreateUseCaseInput(val name: String, val authorId : Long, val description: String)
data class BookCreateUseCaseOutput(val book: Book)

interface BookCreateUseCase {
    fun call(input: BookCreateUseCaseInput) : BookCreateUseCaseOutput
}

@Service
class BookCreateUserCaseImp(
    private val bookRepository: BookRepository
) : BookCreateUseCase {
    override fun call(input: BookCreateUseCaseInput): BookCreateUseCaseOutput {
        val book = Book(
            name = input.name,
            authorId = input.authorId,
            description = input.description
        )
        return BookCreateUseCaseOutput(bookRepository.create(book))
    }

}