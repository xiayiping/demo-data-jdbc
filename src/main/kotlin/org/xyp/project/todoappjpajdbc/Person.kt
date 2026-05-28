package org.xyp.project.todoappjpajdbc

import com.fasterxml.jackson.annotation.JsonValue
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.relational.core.mapping.Embedded
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table

@Table(value = "todos_person")
data class Person(
    @Id
    @Embedded.Nullable
    val id: PersonId,

    var username: String? = null,

    @MappedCollection
    var addresses: List<Address> = listOf(),

    @Version
    var optimisticVersion: Long? = null,
) {

    constructor(pId: PersonId) : this(id = pId)
}

data class PersonId(
    @JsonValue
    val id: Long
)