package ar.com.ddd.ddd_architecture.catalog.presentation.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {
    
    @JsonProperty("isbn")
    private String isbn;
    
    @JsonProperty("name")
    private String name;
}
