package br.com.erudio.controller;


import br.com.erudio.config.SwaggerConfig;
import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.services.BookServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//    @CrossOrigin()
@Api(tags = { SwaggerConfig.TAG_BOOK})
@RestController
@RequestMapping("/api/book/v1")
public class BookController {

    @Autowired
    private BookServices services;
    //    @CrossOrigin()
    @ApiOperation(value = "Salvar livro")
    @PostMapping
    public BookVO create(@RequestBody BookVO book) {
        return services.create(book);
    }
    //    @CrossOrigin()
    @ApiOperation(value = "Atualizar dos livro")
    @PutMapping
    public BookVO update(@RequestBody BookVO book) {
        return services.update(book);
    }
    //    @CrossOrigin()
    @ApiOperation(value = "Deletar Livro")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        services.delete(id);
        return ResponseEntity.ok().build();
    }

//        @CrossOrigin(origins = {"localhost:8080"})
    @ApiOperation(value = "Pesquisar Livro por id")
    @GetMapping(value = "/{id}")
    public BookVO findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }

    //    @CrossOrigin()
    @ApiOperation(value = "Listar todos livros")
    @GetMapping
    public List<BookVO> findAll() {
        return services.findAll();
    }
}
