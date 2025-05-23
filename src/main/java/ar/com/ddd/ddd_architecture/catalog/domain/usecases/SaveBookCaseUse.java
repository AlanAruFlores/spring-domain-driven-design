package ar.com.ddd.ddd_architecture.catalog.domain.usecases;

import ar.com.ddd.ddd_architecture.catalog.domain.models.BookModel;
import ar.com.ddd.ddd_architecture.catalog.domain.repository.BookDAO;
import ar.com.ddd.ddd_architecture.common.utils.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@UseCase
@Slf4j
@RequiredArgsConstructor
public class SaveBookCaseUse {

    private final BookDAO bookDAO;

    public void execute(BookModel bookModel){
        this.bookDAO.save(bookModel);
    }

}