package ar.com.ddd.ddd_architecture.catalog.presentation.controllers.impl;

import ar.com.ddd.ddd_architecture.catalog.domain.models.BookModel;
import ar.com.ddd.ddd_architecture.catalog.domain.usecases.AddBookToCatalogUseCase;
import ar.com.ddd.ddd_architecture.catalog.domain.usecases.DeleteBookByIdUseCase;
import ar.com.ddd.ddd_architecture.catalog.domain.usecases.GetAllBooksUseCase;
import ar.com.ddd.ddd_architecture.catalog.domain.usecases.GetBookByIdUseCase;
import ar.com.ddd.ddd_architecture.catalog.domain.usecases.SaveBookCaseUse;
import ar.com.ddd.ddd_architecture.catalog.presentation.controllers.CatalogController;
import ar.com.ddd.ddd_architecture.catalog.presentation.dto.BookDto;
import ar.com.ddd.ddd_architecture.common.dto.GenericResponse;
import ar.com.ddd.ddd_architecture.common.utils.Converter;
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
        List<BookDto> books = this.getAllBooksUseCase.execute().stream()
            .map(book->Converter.convertToDto(book, BookDto.class))
            .toList();
            
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
