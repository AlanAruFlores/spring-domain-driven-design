package ar.com.ddd.ddd_architecture.catalog.application;

import ar.com.ddd.ddd_architecture.catalog.domain.Isbn;

public interface ISearchService {
    BookInformation search(Isbn isbn);
}
