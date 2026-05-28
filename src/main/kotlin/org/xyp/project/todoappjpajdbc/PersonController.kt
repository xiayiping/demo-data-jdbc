package org.xyp.project.todoappjpajdbc

import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/persons")
@RestController
class PersonController(val personRepo: PersonRepo, val txOp: TransactionalOp) {

    @GetMapping("")
    fun getPersons(): List<Person> = personRepo.findAll(PageRequest.of(0, 20)).toList()

    @GetMapping("{id}")
    fun getPersonById(@PathVariable("id") id: Long): Person? {
        val ps = txOp.returnInTransaction {
            val p = Person(PersonId(id))
            p.username = "uname-$id"
            p.addresses = listOf(Address(AddressId(id), "feng yang street"))
            personRepo.save(p)
        }
        return personRepo.findById(PersonId(id)).orElse(null)
    }

    @GetMapping("{id}/update")
    fun updatePersonById(@PathVariable("id") id: Long): Person? {
        return txOp.returnInTransaction {
            val p = personRepo.findById(PersonId(id)).orElse(null)
            p.username = "uname-$id ${System.currentTimeMillis()}"
            personRepo.save(p)
        }
    }


}