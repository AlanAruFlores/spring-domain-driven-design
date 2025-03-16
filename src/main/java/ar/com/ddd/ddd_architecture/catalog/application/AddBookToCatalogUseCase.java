package ar.com.ddd.ddd_architecture.catalog.application;

import ar.com.ddd.ddd_architecture.catalog.domain.Book;
import ar.com.ddd.ddd_architecture.catalog.domain.BookRepository;
import ar.com.ddd.ddd_architecture.catalog.domain.Isbn;
import org.antlr.v4.runtime.misc.NotNull;

@UseCase
public class AddBookToCatalogUseCase {

    private ISearchService searchService;
    private BookRepository bookRepository;

    public AddBookToCatalogUseCase(BookRepository bookRepository, ISearchService searchService) {
        this.searchService = searchService;
        this.bookRepository = bookRepository;
    }

    public void execute(@NotNull Isbn isbn){
        BookInformation information = this.searchService.search(isbn);
        this.bookRepository.save(new Book(isbn,information.title()));
    }

}
