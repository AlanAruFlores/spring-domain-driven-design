package ar.com.ddd.ddd_architecture.catalog.infrastructure.providers;

import java.util.List;

public record OpenClientResultsJson(List<String> publishers,
                                    String title,
                                    List<String> isbn_13,
                                    int revisions) {
}
