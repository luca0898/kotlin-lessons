package br.com.kotlin.lessons.services

import br.com.kotlin.lessons.exeptions.ResourceNotFoundException
import br.com.kotlin.lessons.models.Person
import br.com.kotlin.lessons.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    fun findAll(): List<Person> {
        return repository.findAll()
    }

    fun findById(id: Long): Person {
        return repository
            .findById(id)
            .orElseThrow { ResourceNotFoundException("") }
    }

    fun create(person: Person): Person {
        return repository.save(person)
    }

    fun update(person: Person): Person {
        val entity = repository
            .findById(person.id)
            .orElseThrow { ResourceNotFoundException("") }

        entity.id = person.id
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return repository.save(entity)
    }

    fun delete(id: Long) {
        return repository.deleteById(id)
    }
}