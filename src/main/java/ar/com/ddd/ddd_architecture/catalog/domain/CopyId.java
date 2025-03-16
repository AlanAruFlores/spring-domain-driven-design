package ar.com.ddd.ddd_architecture.catalog.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record CopyId(UUID id) {
    public CopyId{
        Assert.notNull(id, "The identifier cannot be null");
    }
    public CopyId(){
        this(UUID.randomUUID());
    }
}
