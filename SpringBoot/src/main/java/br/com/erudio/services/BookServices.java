package br.com.erudio.services;


import br.com.erudio.controllers.BookController;
import br.com.erudio.controllers.PersonController;
import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exceptions.RequiredObjectIsNullException;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.model.Book;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookServices {

    private Logger logger = Logger.getLogger(BookServices.class.getName());

    @Autowired
    BookRepository bookRepository;

    public List<BookVO> findAll(){

        logger.info("Finding all books");

        var books = DozerMapper.parseListObjects(bookRepository.findAll(), BookVO.class);
        books.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class)
                .findById(p.getKey())).withSelfRel()));
        return books;
    }

    public BookVO findById(Long id){

        logger.info("Finding a book");

        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var vo = DozerMapper.parseObject(book, BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return vo;
    }

    public BookVO create(BookVO book) {

        if(book == null) throw new RequiredObjectIsNullException();


        logger.info("Creating one person!");
        var entity = DozerMapper.parseObject(book, Book.class);
        var vo =  DozerMapper.parseObject(bookRepository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public BookVO update(BookVO book) {

        if(book == null) throw new RequiredObjectIsNullException();
        logger.info("Updating one person!");

        var entity = bookRepository.findById(book.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunch_date(book.getLaunch_date());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        var vo =  DozerMapper.parseObject(bookRepository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");

        var entity = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        bookRepository.delete(entity);
    }



}
