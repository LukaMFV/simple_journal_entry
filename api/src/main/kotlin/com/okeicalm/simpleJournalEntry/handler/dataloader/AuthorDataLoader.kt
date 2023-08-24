package com.okeicalm.simpleJournalEntry.handler.dataloader

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.execution.KotlinDataLoader
import com.okeicalm.simpleJournalEntry.handler.type.AuthorType
import com.okeicalm.simpleJournalEntry.repository.AuthorRepository
import org.dataloader.DataLoader
import org.dataloader.DataLoaderFactory
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class AuthorDataLoader(private val repository: AuthorRepository) : KotlinDataLoader<ID, AuthorType> {

    override val dataLoaderName: String = DATA_LOADER_NAME
    override fun getDataLoader(): DataLoader<ID, AuthorType> = DataLoaderFactory.newDataLoader { ids ->
        println("AuthorDataLoader $ids")
        CompletableFuture.supplyAsync {
            repository.filterByIds(ids.map { it.toString().toLong() }).map { AuthorType(it) }
        }
    }

    companion object {
        const val DATA_LOADER_NAME = "AuthorDataLoader"
    }
}