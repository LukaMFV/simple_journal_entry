package com.okeicalm.simpleJournalEntry.handler.dataloader

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.execution.KotlinDataLoader
import com.okeicalm.simpleJournalEntry.handler.type.AuthorType
import com.okeicalm.simpleJournalEntry.handler.type.BookType
import com.okeicalm.simpleJournalEntry.repository.AuthorRepository
import com.okeicalm.simpleJournalEntry.repository.BookRepository
import org.dataloader.DataLoader
import org.dataloader.DataLoaderFactory
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class BookDataLoader(private val repository: BookRepository) : KotlinDataLoader<ID, BookType> {

    override val dataLoaderName: String = "BookDataLoader"
    override fun getDataLoader(): DataLoader<ID, BookType> = DataLoaderFactory.newDataLoader { ids ->
        CompletableFuture.supplyAsync {
            repository.filterByIds(ids.map { it.toString().toLong() }).map { BookType(it) }
        }
    }

}