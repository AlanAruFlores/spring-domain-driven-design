package ar.com.ddd.ddd_architecture.catalog.domain.usecases;
import ar.com.ddd.ddd_architecture.catalog.domain.models.BookModel;
import ar.com.ddd.ddd_architecture.catalog.domain.repository.BookDAO;
import ar.com.ddd.ddd_architecture.common.utils.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@UseCase
@Slf4j
@RequiredArgsConstructor    
public class GetAllBooksUseCase {

    private final BookDAO bookDAO;


    /*NotNull allows to no send NULL VALUES*/
    public List<BookModel> execute(){
        return this.bookDAO.findAll();
    }

}
