package ar.com.ddd.ddd_architecture.catalog.infrastructure.client;

import ar.com.ddd.ddd_architecture.catalog.domain.models.BookInformationModel;
import ar.com.ddd.ddd_architecture.catalog.domain.providers.BookClientProvider;
import ar.com.ddd.ddd_architecture.shared.utils.HttpWebClient;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.client.RestClient;

@HttpWebClient
@Slf4j
public class BookSearchClient implements BookClientProvider {
    private final RestClient restClient;

    //We are going to inject the rest client here to make requests to EXTERNAL SERVICES
    public BookSearchClient(RestClient.Builder builder){
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
