package ar.com.ddd.ddd_architecture.catalog.application;

import ar.com.ddd.ddd_architecture.catalog.domain.models.BookInformationModel;
import ar.com.ddd.ddd_architecture.catalog.domain.models.BookModel;
import ar.com.ddd.ddd_architecture.catalog.domain.providers.BookClientProvider;
import ar.com.ddd.ddd_architecture.catalog.domain.providers.BookDAOProvider;
import ar.com.ddd.ddd_architecture.shared.utils.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@UseCase
@Slf4j
@RequiredArgsConstructor
public class AddBookToCatalogUseCase {

    private final BookClientProvider bookProvider;
    private final BookDAOProvider bookDAO;

    public void execute(String isbn){
        BookInformationModel information = this.bookProvider.search(isbn);
        this.bookDAO.save(new BookModel(isbn,information.getTitle()));
    }

}
