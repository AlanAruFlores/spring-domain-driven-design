package ar.com.ddd.ddd_architecture.catalog.domain.providers;

import ar.com.ddd.ddd_architecture.catalog.domain.models.BookInformationModel;

public interface BookProvider {
    public BookInformationModel search(String isbn);
}
