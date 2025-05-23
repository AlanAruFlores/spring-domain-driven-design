package ar.com.ddd.ddd_architecture.catalog.infrastructure.persistence.impl;

import ar.com.ddd.ddd_architecture.catalog.infrastructure.persistence.BookPersistenceDAO;
import ar.com.ddd.ddd_architecture.catalog.infrastructure.persistence.repository.BookHibernateRepository;
import ar.com.ddd.ddd_architecture.common.utils.Converter;
import ar.com.ddd.ddd_architecture.common.utils.DataAccessObject;
import ar.com.ddd.ddd_architecture.catalog.domain.models.BookModel;
import ar.com.ddd.ddd_architecture.catalog.infrastructure.entity.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@DataAccessObject
@RequiredArgsConstructor
@Slf4j
public class BookPersistenceDAOImpl implements BookPersistenceDAO {

    private final BookHibernateRepository bookRepository;

    @Override
    public List<BookModel> findAll() {
        return bookRepository.findAll().stream()
            .map(b->Converter.convertToModel(b, BookModel.class))
            .toList();
    }

    @Override
    public BookModel findById(Long id) {
        return Converter.convertToModel(bookRepository.findById(id).get(), BookModel.class);      
    }

    @Override
    public BookModel save(BookModel book) {
        Book entity = Converter.convertToEntity(book, Book.class);
        bookRepository.save(entity);
        return book;
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
