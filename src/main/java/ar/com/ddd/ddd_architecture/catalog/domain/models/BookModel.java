package ar.com.ddd.ddd_architecture.catalog.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookModel {
    
    private String isbn;
    private String name;
}
