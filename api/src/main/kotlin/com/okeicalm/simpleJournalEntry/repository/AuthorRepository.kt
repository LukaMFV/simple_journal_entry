package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Author
import com.okeicalm.simpleJournalEntry.entity.Book
import com.okeicalm.simpleJournalEntry.infra.db.tables.Accounts
import com.okeicalm.simpleJournalEntry.infra.db.tables.Authors
import com.okeicalm.simpleJournalEntry.infra.db.tables.references.AUTHORS
import com.okeicalm.simpleJournalEntry.infra.db.tables.references.BOOKS
import com.okeicalm.simpleJournalEntry.infra.db.tables.references.JOURNALS
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

interface AuthorRepository {
    fun findAll(): List<Author>
    fun searchByName(name: String): List<Author>
    fun findById(id: Long): Author?
    fun filterByIds(ids: List<Long>): List<Author>
    fun create(author: Author): Author
    fun update(author: Author): Author
    fun delete(id: Long): Long
}

@Repository
class AuthorRepositoryImpl(private val dslContext: DSLContext) : AuthorRepository {
//    override fun findAll(): List<Author> {
//        return dslContext.select()
//            .from(Authors.AUTHORS)
//            .fetch()
//            .into(Author::class.java)
//    }

    override fun findAll(): List<Author> {
        val records = dslContext
            .select(
                AUTHORS.ID, AUTHORS.NAME, AUTHORS.ADDRESS, AUTHORS.AGE,
                BOOKS.ID, BOOKS.NAME, BOOKS.DESCRIPTION, BOOKS.AUTHOR_ID
            )
            .from(AUTHORS)
            .join(BOOKS)
            .on(AUTHORS.ID.eq(BOOKS.AUTHOR_ID))
            .fetch()

        val authorMap = records.groupBy { it[AUTHORS.ID] }
        return authorMap.map { j ->
            val bookList = j.value.map { je ->
                Book(
                    id = je.getValue(BOOKS.ID)!!,
                    name = je.getValue(BOOKS.NAME)!!,
                    authorId = je.getValue(BOOKS.AUTHOR_ID)!!,
                    description = je.getValue(BOOKS.DESCRIPTION)!!
                )
            }
            Author(
                id = j.key!!,
                age = j.value.first().getValue(AUTHORS.AGE)!!,
                name = j.value.first().getValue(AUTHORS.NAME)!!,
                address = j.value.first().getValue(AUTHORS.ADDRESS)!!,
                bookList = bookList
            )
        }
    }

    override fun findById(id: Long): Author? {
        return dslContext
            .fetchOne(Authors.AUTHORS, Authors.AUTHORS.ID.eq(id))
            ?.into(Author::class.java)
    }

    override fun filterByIds(ids: List<Long>): List<Author> {
        val records = dslContext
            .select()
            .from(AUTHORS)
            .where(AUTHORS.ID.`in`(ids))
            .fetch()
        return records.map {
            Author(
                id = it.getValue(AUTHORS.ID)!!,
                age = it.getValue(AUTHORS.AGE)!!,
                name = it.getValue(AUTHORS.NAME)!!,
                address = it.getValue(AUTHORS.ADDRESS)!!,
                bookList = listOf()
            )
        }
    }

    override fun create(author: Author): Author {
        val record = dslContext
            .newRecord(AUTHORS)
            .apply {
                name = author.name
                age = author.age
                address = author.address
            }
        record.store()

        return author.copy(id = record.id!!)
    }

    override fun update(author: Author): Author {
        dslContext
            .update(Authors.AUTHORS)
            .set(Authors.AUTHORS.NAME, author.name)
            .set(Authors.AUTHORS.ADDRESS, author.address)
            .where(Authors.AUTHORS.ID.eq(author.id))
            .execute()
        return author
    }

    override fun delete(id: Long): Long {
        dslContext
            .delete(Accounts.ACCOUNTS)
            .where(Accounts.ACCOUNTS.ID.eq(id))
            .execute()
        return id
    }

    override fun searchByName(name: String): List<Author> {
        return dslContext
            .select()
            .from(AUTHORS)
            .where(AUTHORS.NAME.like("%$name%"))
            .fetch()
            .map {
                Author(
                    id = it.getValue(AUTHORS.ID)!!,
                    age = it.getValue(AUTHORS.AGE)!!,
                    name = it.getValue(AUTHORS.NAME)!!,
                    address = it.getValue(AUTHORS.ADDRESS)!!,
                    bookList = listOf()
                )
            }
    }
}
