package ar.com.ddd.ddd_architecture.catalog.presentation.impl;

import ar.com.ddd.ddd_architecture.catalog.application.AddBookToCatalogUseCase;
import ar.com.ddd.ddd_architecture.catalog.application.DeleteBookByIdUseCase;
import ar.com.ddd.ddd_architecture.catalog.application.GetAllBooksUseCase;
import ar.com.ddd.ddd_architecture.catalog.application.GetBookByIdUseCase;
import ar.com.ddd.ddd_architecture.catalog.application.SaveBookCaseUse;
import ar.com.ddd.ddd_architecture.catalog.domain.models.BookModel;
import ar.com.ddd.ddd_architecture.catalog.presentation.CatalogController;
import ar.com.ddd.ddd_architecture.catalog.presentation.dto.BookDto;
import ar.com.ddd.ddd_architecture.shared.dto.GenericResponse;
import ar.com.ddd.ddd_architecture.shared.utils.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CatalogControllerImpl implements CatalogController{
    private final GetAllBooksUseCase getAllBooksUseCase;
    private final AddBookToCatalogUseCase addBookToCatalogUseCase;
    private final DeleteBookByIdUseCase deleteBookByIdUseCase;
    private final GetBookByIdUseCase getBookByIdUseCase;
    private final SaveBookCaseUse saveBookCaseUse;

    @Override
    public GenericResponse<List<BookDto>> getAllBooks(){
        log.info("Get all books");
        List<BookDto> books = Converter.convertToList(this.getAllBooksUseCase.execute()
            , BookDto.class);
    
            
        return GenericResponse.<List<BookDto>>builder()
                .code(HttpStatus.OK.value())
                .message("Books retrieved successfully")
                .data(books)
                .build();
    }

    @Override
    public GenericResponse<Void> saveBook(BookDto bookDto){
        log.info("Save book");
        this.saveBookCaseUse.execute(Converter.convertToModel(bookDto, BookModel.class));

        return GenericResponse.<Void>builder()
                .code(HttpStatus.CREATED.value())
                .message("Book saved successfully")
                .build();
    }
}
