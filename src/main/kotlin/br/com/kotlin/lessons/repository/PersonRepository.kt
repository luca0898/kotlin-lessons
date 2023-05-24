package br.com.kotlin.lessons.repository

import br.com.kotlin.lessons.models.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long?>