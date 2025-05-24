package ar.com.ddd.ddd_architecture.catalog.application;

import ar.com.ddd.ddd_architecture.catalog.domain.models.BookModel;
import ar.com.ddd.ddd_architecture.catalog.domain.providers.BookDAOProvider;
import ar.com.ddd.ddd_architecture.shared.utils.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@UseCase
@Slf4j
@RequiredArgsConstructor
public class GetBookByIdUseCase {
    
    private final BookDAOProvider bookDAO;

    public BookModel execute(Long id){
        return this.bookDAO.findById(id);
    }
}
