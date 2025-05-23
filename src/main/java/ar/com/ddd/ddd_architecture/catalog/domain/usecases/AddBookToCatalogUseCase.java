package ar.com.ddd.ddd_architecture.catalog.domain.usecases;

import ar.com.ddd.ddd_architecture.catalog.domain.models.BookInformationModel;
import ar.com.ddd.ddd_architecture.catalog.domain.models.BookModel;
import ar.com.ddd.ddd_architecture.catalog.domain.providers.BookProvider;
import ar.com.ddd.ddd_architecture.catalog.domain.repository.BookDAO;
import ar.com.ddd.ddd_architecture.common.utils.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@UseCase
@Slf4j
@RequiredArgsConstructor
public class AddBookToCatalogUseCase {

    private final BookProvider bookProvider;
    private final BookDAO bookDAO;

    public void execute(String isbn){
        BookInformationModel information = this.bookProvider.search(isbn);
        this.bookDAO.save(new BookModel(isbn,information.getTitle()));
    }

}
