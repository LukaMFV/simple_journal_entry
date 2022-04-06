/*
 * This file is generated by jOOQ.
 */
package com.okeicalm.simpleJournalEntry.infra.db.tables


import com.okeicalm.simpleJournalEntry.infra.db.SimpleJournalEntryDb
import com.okeicalm.simpleJournalEntry.infra.db.keys.KEY_ACCOUNTS_CODE
import com.okeicalm.simpleJournalEntry.infra.db.keys.KEY_ACCOUNTS_PRIMARY
import com.okeicalm.simpleJournalEntry.infra.db.tables.records.AccountsRecord

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Row4
import org.jooq.Schema
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Accounts(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, AccountsRecord>?,
    aliased: Table<AccountsRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<AccountsRecord>(
    alias,
    SimpleJournalEntryDb.SIMPLE_JOURNAL_ENTRY_DB,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of
         * <code>simple_journal_entry_db.accounts</code>
         */
        val ACCOUNTS: Accounts = Accounts()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<AccountsRecord> = AccountsRecord::class.java

    /**
     * The column <code>simple_journal_entry_db.accounts.id</code>.
     */
    val ID: TableField<AccountsRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>simple_journal_entry_db.accounts.code</code>.
     */
    val CODE: TableField<AccountsRecord, String?> = createField(DSL.name("code"), SQLDataType.VARCHAR(50).nullable(false), this, "")

    /**
     * The column <code>simple_journal_entry_db.accounts.name</code>.
     */
    val NAME: TableField<AccountsRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR(50).nullable(false), this, "")

    /**
     * The column <code>simple_journal_entry_db.accounts.element_type</code>.
     */
    val ELEMENT_TYPE: TableField<AccountsRecord, Int?> = createField(DSL.name("element_type"), SQLDataType.INTEGER.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<AccountsRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<AccountsRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>simple_journal_entry_db.accounts</code> table
     * reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>simple_journal_entry_db.accounts</code> table
     * reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>simple_journal_entry_db.accounts</code> table reference
     */
    constructor(): this(DSL.name("accounts"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, AccountsRecord>): this(Internal.createPathAlias(child, key), child, key, ACCOUNTS, null)
    override fun getSchema(): Schema? = if (aliased()) null else SimpleJournalEntryDb.SIMPLE_JOURNAL_ENTRY_DB
    override fun getIdentity(): Identity<AccountsRecord, Long?> = super.getIdentity() as Identity<AccountsRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<AccountsRecord> = KEY_ACCOUNTS_PRIMARY
    override fun getUniqueKeys(): List<UniqueKey<AccountsRecord>> = listOf(KEY_ACCOUNTS_CODE)
    override fun `as`(alias: String): Accounts = Accounts(DSL.name(alias), this)
    override fun `as`(alias: Name): Accounts = Accounts(alias, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Accounts = Accounts(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Accounts = Accounts(name, null)

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row4<Long?, String?, String?, Int?> = super.fieldsRow() as Row4<Long?, String?, String?, Int?>
}
