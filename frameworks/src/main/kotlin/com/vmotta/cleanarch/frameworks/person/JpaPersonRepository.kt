package com.vmotta.cleanarch.frameworks.person

import com.vmotta.cleanarch.entities.person.Person
import com.vmotta.cleanarch.entities.person.PersonRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.UUID

@Repository
interface PersonRepositoryInterface : JpaRepository<Person, UUID>

@Service
class JpaPersonRepository(
    private val springPersonRepository: PersonRepositoryInterface
) : PersonRepository {
    override fun save(person: Person): Person {
        return springPersonRepository.save(person)
    }

    override fun delete(person: Person) {
        return springPersonRepository.delete(person)
    }

    override fun findById(id: UUID): Person? {
        return springPersonRepository.findByIdOrNull(id)
    }

    override fun findAll(): List<Person> {
        return springPersonRepository.findAll()
    }
}