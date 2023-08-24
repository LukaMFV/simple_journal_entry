package com.okeicalm.simpleJournalEntry.handler.type

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.extensions.getValueFromDataLoader
import com.okeicalm.simpleJournalEntry.entity.Book
import com.okeicalm.simpleJournalEntry.handler.dataloader.AuthorDataLoader
import graphql.schema.DataFetchingEnvironment
import java.util.concurrent.CompletableFuture

const val bookTypeGraphQLName = "Book"
@GraphQLName(bookTypeGraphQLName)
data class BookType(
    val id: ID,
    val name: String,
    val authorId : ID,
    val description: String
) {
    constructor(book: Book) : this (
        ID(book.id.toString()),
        book.name,
        ID(book.authorId.toString()),
        book.description
    )

    fun author(dataFetchingEnvironment: DataFetchingEnvironment): CompletableFuture<AuthorType> {
        return dataFetchingEnvironment.getValueFromDataLoader(AuthorDataLoader.DATA_LOADER_NAME, authorId)
    }
}