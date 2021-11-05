package br.com.erudio.services;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repo;

    public Person create(Person person) {
        return repo.save(person);
    }

    public Person update(Person person) {
        Person entity = repo.findById(person.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Registro não encontrado.")
        );

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repo.save(entity);
    }

    public void delete(Long id) {

        Person entity = repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Registro não encontrado.")
        );

        repo.delete(entity);
    }

    public Person findById(Long id) {
        return repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Registro não encontrado.")
        );
    }

    public List<Person> findAll() {
        return repo.findAll();
    }

}
