package ar.com.ddd.ddd_architecture.catalog.infrastructure;

import ar.com.ddd.ddd_architecture.catalog.application.BookInformation;
import ar.com.ddd.ddd_architecture.catalog.application.ISearchService;
import ar.com.ddd.ddd_architecture.catalog.domain.Isbn;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BookSearchService implements ISearchService {
    private final RestClient restClient;

    //We are going to inject the rest client here to make requests to EXTERNAL SERVICES
    public BookSearchService(RestClient.Builder builder){
        restClient = builder
                .baseUrl("https://openlibray.org/")
                .build();
    }

    @Override
    public BookInformation search(Isbn isbn){
        OpenClientResultsJson result =  restClient.get().uri("isbn/{isbn}.json", isbn.valueIsbn()) //request
                .retrieve()// get the resposne
                .body(OpenClientResultsJson.class);// result format

        return new BookInformation(result.title());

    }


}
