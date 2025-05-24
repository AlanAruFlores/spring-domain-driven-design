package ar.com.ddd.ddd_architecture.catalog.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ddd.ddd_architecture.catalog.presentation.dto.BookDto;
import ar.com.ddd.ddd_architecture.shared.dto.GenericResponse;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RequestMapping("/catalog/v1")
public interface CatalogController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all books")
    GenericResponse<List<BookDto>> getAllBooks();
    

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Save book")
    GenericResponse<Void> saveBook(@RequestBody BookDto bookDto);
    
}
