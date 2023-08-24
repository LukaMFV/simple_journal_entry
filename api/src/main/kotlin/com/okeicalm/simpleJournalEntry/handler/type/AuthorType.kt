package com.okeicalm.simpleJournalEntry.handler.type

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.extensions.getValueFromDataLoader
import com.okeicalm.simpleJournalEntry.entity.Author
import com.okeicalm.simpleJournalEntry.handler.dataloader.BookListDataLoader
import graphql.schema.DataFetchingEnvironment
import java.util.concurrent.CompletableFuture

const val authorTypeGraphQLName = "Author"

@GraphQLName(authorTypeGraphQLName)
data class AuthorType(
    val id: ID,
    val name: String,
    val age: Int,
    val address: String,
    val bookList: List<BookType>
) {
    constructor(author: Author) : this(
        ID(author.id.toString()),
        author.name,
        author.age,
        author.address,
        author.bookList.map { it -> BookType(it) }
    )

    fun books(dataFetchingEnvironment: DataFetchingEnvironment): CompletableFuture<List<BookType>> {
        return dataFetchingEnvironment.getValueFromDataLoader(BookListDataLoader.DATA_LOADER_NAME, id)
    }
}
