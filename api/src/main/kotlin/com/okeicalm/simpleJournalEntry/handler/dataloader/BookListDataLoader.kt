package com.okeicalm.simpleJournalEntry.handler.dataloader

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.execution.KotlinDataLoader
import com.okeicalm.simpleJournalEntry.handler.type.BookType
import com.okeicalm.simpleJournalEntry.repository.BookRepository
import org.dataloader.DataLoader
import org.dataloader.DataLoaderFactory
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class BookListDataLoader(val bookRepository: BookRepository) : KotlinDataLoader<ID, List<BookType>> {

    override val dataLoaderName = DATA_LOADER_NAME
    override fun getDataLoader(): DataLoader<ID, List<BookType>> =
        DataLoaderFactory.newDataLoader { ids ->
            CompletableFuture.supplyAsync {
                ids.map { id ->
                    bookRepository.filterByAuthorId(id.toString().toLong())
                        .map { BookType(it) }
                }
            }
        }
    companion object {
        const val DATA_LOADER_NAME = "BookListDataLoader"
    }
}