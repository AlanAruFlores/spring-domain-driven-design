package ar.com.ddd.ddd_architecture.catalog.presentation.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    
    private String isbn;
    private String name;
}
