package br.com.erudio.controller;

import br.com.erudio.config.SwaggerConfig;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin
@Api(tags = SwaggerConfig.TAG_PERSON)
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices services;

    //    Forma Antiga dde se fazer o mapeamento
//    @RequestMapping(method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)

//    @CrossOrigin( origins = {"localhost:8080"})
    @ApiOperation(value = "Pesquisa todas as pessoas")
    @GetMapping
    public List<PersonVO> findAll() {
        return services.findAll();
    }

    //    Forma Antiga dde se fazer o mapeamento
//    @RequestMapping(value = "/{id}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)

    //    @CrossOrigin()
    @ApiOperation(value = "Pesquisa por chave")
    @GetMapping("/{id}")
    public PersonVO findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }

//    Forma Antiga dde se fazer o mapeamento
//    @RequestMapping(method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)

//    @CrossOrigin()
    @ApiOperation(value = "Salvar pessoa")
    @PostMapping
    public PersonVO create(@RequestBody PersonVO person) {
        return services.create(person);
    }

    //    Forma Antiga dde se fazer o mapeamento
//    @RequestMapping(method = RequestMethod.PUT,
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
    //    @CrossOrigin()
    @ApiOperation(value = "Atualizar dados pessoa")
    @PutMapping
    public PersonVO update(@RequestBody PersonVO person) {
        return services.update(person);
    }

    //    Forma Antiga dde se fazer o mapeamento
//    @RequestMapping(value = "/{id}",
//            method = RequestMethod.DELETE)
    //    @CrossOrigin()
    @ApiOperation(value = "Deletar pessoa")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.ok().build();
    }
}
