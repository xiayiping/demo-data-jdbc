package org.xyp.project.todoappjpajdbc

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.relational.core.mapping.NamingStrategy
import org.springframework.data.relational.core.mapping.RelationalPersistentEntity
import org.springframework.data.relational.core.mapping.RelationalPersistentProperty
import java.lang.reflect.Field


@Configuration
class CustomNamingStrategyConfig {

    @Bean
    fun namingStrategy(): NamingStrategy = CustomNamingStrategy()
}

class CustomNamingStrategy : NamingStrategy {
//    override fun getTableName(type: Class<*>): String {
//        // Use the default logic, but respect user-defined table names
//        return super.getTableName(type).lowercase()
//    }
//
//    override fun getColumnName(property: RelationalPersistentProperty): String {
//        return super.getColumnName(property).lowercase()
//    }
//
//    override fun getReverseColumnName(property: RelationalPersistentProperty): String {
//        return super.getReverseColumnName(property).lowercase()
//    }
//
//    override fun getReverseColumnName(owner: RelationalPersistentEntity<*>): String {
//        return super.getReverseColumnName(owner).lowercase()
//    }
//
//    override fun getKeyColumn(property: RelationalPersistentProperty): String {
//        return super.getKeyColumn(property).lowercase()
//    }
}