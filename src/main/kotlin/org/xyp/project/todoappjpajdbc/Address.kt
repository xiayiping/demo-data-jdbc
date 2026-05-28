package org.xyp.project.todoappjpajdbc

import com.fasterxml.jackson.annotation.JsonValue
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.relational.core.mapping.Embedded
import org.springframework.data.relational.core.mapping.Table

@Table(value = "todos_address")
data class Address(
    @Id
    @Embedded.Nullable
    val id: AddressId,

    var street: String,

    @Version
    var optimisticVersion: Long? = null,
)

data class AddressId(
    @JsonValue
    val id: Long
)