package ar.com.ddd.ddd_architecture.catalog.infrastructure.providers;

import ar.com.ddd.ddd_architecture.catalog.domain.models.BookInformationModel;
import ar.com.ddd.ddd_architecture.catalog.domain.providers.BookProvider;
import ar.com.ddd.ddd_architecture.common.utils.Provider;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.client.RestClient;

@Provider
@Slf4j
public class BookSearchProvider implements BookProvider {
    private final RestClient restClient;

    //We are going to inject the rest client here to make requests to EXTERNAL SERVICES
    public BookSearchProvider(RestClient.Builder builder){
        restClient = builder
                .baseUrl("https://openlibray.org/")
                .build();
    }

    @Override
    public BookInformationModel search(String isbn){
        OpenClientResultsJson result =  restClient.get().uri("isbn/{isbn}.json", isbn) //request
                .retrieve()// get the resposne
                .body(OpenClientResultsJson.class);// result format

        return new BookInformationModel(result.title());

    }


}
