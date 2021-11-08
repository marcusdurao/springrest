package br.com.erudio.services;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.data.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repo;

    public PersonVO create(PersonVO personVO) {
        var entity = DozerConverter.parseObject(personVO, Person.class);
        var vo = DozerConverter.parseObject(repo.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO personVO) {
        var entity =  repo.findById(personVO.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Registro não encontrado.")
        );

        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setAddress(personVO.getAddress());
        entity.setGender(personVO.getGender());

        return DozerConverter.parseObject(repo.save(entity), PersonVO.class);
    }

    public void delete(Long id) {

        Person entity = repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Registro não encontrado.")
        );

        repo.delete(entity);
    }

    public PersonVO findById(Long id) {
        var entity = repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Registro não encontrado.")
        );
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        return  DozerConverter.parseListObjects(repo.findAll(), PersonVO.class);
    }

}
