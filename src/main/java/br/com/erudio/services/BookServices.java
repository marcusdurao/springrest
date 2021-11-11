package br.com.erudio.services;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.data.Book;
import br.com.erudio.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {

    @Autowired
    BookRepository repo;

    public BookVO create(BookVO book) {
        var entity = DozerConverter.parseObject(book, Book.class);
        var vo = DozerConverter.parseObject(repo.save(entity), BookVO.class);

        return vo;
    }

    public BookVO update(BookVO book) {
        var entity = repo.findById(book.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Book não encontrado.")
        );

        entity.setId(book.getId());
        entity.setAuthor(book.getAuthor());
        entity.setLaunch_date(book.getLaunch_date());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        return DozerConverter.parseObject(repo.save(entity), BookVO.class);
    }

    public void delete(Long id) {

        Book book = repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book não encontrado.")
        );
        repo.delete(book);
    }

    public BookVO findById(Long id) {

        var entity = repo.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Book não encontrado.")
        );

        return DozerConverter.parseObject(entity, BookVO.class);
    }

    public List<BookVO> findAll() {
         return DozerConverter.parseListObjects(repo.findAll(), BookVO.class);
    }
}
