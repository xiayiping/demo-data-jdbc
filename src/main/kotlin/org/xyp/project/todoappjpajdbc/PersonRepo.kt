package org.xyp.project.todoappjpajdbc

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepo : PagingAndSortingRepository<Person, PersonId>, CrudRepository<Person, PersonId> {
}