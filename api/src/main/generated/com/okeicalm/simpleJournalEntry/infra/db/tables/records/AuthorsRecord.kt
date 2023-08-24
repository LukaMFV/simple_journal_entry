/*
 * This file is generated by jOOQ.
 */
package com.okeicalm.simpleJournalEntry.infra.db.tables.records


import com.okeicalm.simpleJournalEntry.infra.db.tables.Authors

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record4
import org.jooq.Row4
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class AuthorsRecord() : UpdatableRecordImpl<AuthorsRecord>(Authors.AUTHORS), Record4<Long?, String?, Int?, String?> {

    var id: Long?
        set(value): Unit = set(0, value)
        get(): Long? = get(0) as Long?

    var name: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    var age: Int?
        set(value): Unit = set(2, value)
        get(): Int? = get(2) as Int?

    var address: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row4<Long?, String?, Int?, String?> = super.fieldsRow() as Row4<Long?, String?, Int?, String?>
    override fun valuesRow(): Row4<Long?, String?, Int?, String?> = super.valuesRow() as Row4<Long?, String?, Int?, String?>
    override fun field1(): Field<Long?> = Authors.AUTHORS.ID
    override fun field2(): Field<String?> = Authors.AUTHORS.NAME
    override fun field3(): Field<Int?> = Authors.AUTHORS.AGE
    override fun field4(): Field<String?> = Authors.AUTHORS.ADDRESS
    override fun component1(): Long? = id
    override fun component2(): String? = name
    override fun component3(): Int? = age
    override fun component4(): String? = address
    override fun value1(): Long? = id
    override fun value2(): String? = name
    override fun value3(): Int? = age
    override fun value4(): String? = address

    override fun value1(value: Long?): AuthorsRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): AuthorsRecord {
        this.name = value
        return this
    }

    override fun value3(value: Int?): AuthorsRecord {
        this.age = value
        return this
    }

    override fun value4(value: String?): AuthorsRecord {
        this.address = value
        return this
    }

    override fun values(value1: Long?, value2: String?, value3: Int?, value4: String?): AuthorsRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        return this
    }

    /**
     * Create a detached, initialised AuthorsRecord
     */
    constructor(id: Long? = null, name: String? = null, age: Int? = null, address: String? = null): this() {
        this.id = id
        this.name = name
        this.age = age
        this.address = address
    }
}
