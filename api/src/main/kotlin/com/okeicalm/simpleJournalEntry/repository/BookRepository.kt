package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Account
import com.okeicalm.simpleJournalEntry.entity.Book
import com.okeicalm.simpleJournalEntry.infra.db.tables.references.BOOKS
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

interface BookRepository {
    fun create(book: Book): Book
    fun filterByIds(ids: List<Long>): List<Book>
    fun filterByAuthorId(authorId: Long): List<Book>

    fun findAll(): List<Book>
}

@Repository
class BookRepositoryImp(private val dslContext: DSLContext): BookRepository{
    override fun create(book: Book): Book {
        val record = dslContext
            .newRecord(BOOKS)
            .apply {
                name = book.name
                authorId = book.authorId
                description = book.description
            }
        record.store()
        return book.copy(id = record.id!!)
    }

    override fun filterByIds(ids: List<Long>): List<Book> {
        return dslContext
            .select()
            .from(BOOKS)
            .where(BOOKS.ID.`in`(ids))
            .fetchInto(Book::class.java)
    }

    override fun filterByAuthorId(authorId: Long): List<Book> {
        return dslContext
            .select()
            .from(BOOKS)
            .where(BOOKS.AUTHOR_ID.eq(authorId))
            .fetchInto(Book::class.java)
    }

    override fun findAll(): List<Book> {
        return dslContext
            .select()
            .from(BOOKS)
            .fetchInto(Book::class.java)
    }

}