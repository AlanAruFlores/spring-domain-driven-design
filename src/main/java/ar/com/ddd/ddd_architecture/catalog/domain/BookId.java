package ar.com.ddd.ddd_architecture.catalog.domain;

import org.springframework.util.Assert;

import java.util.UUID;

/*
* In DDD, is recomendable to make the IDENTIFIERS LIKE A CLASS for each ENTITYS or AGREGATES
* */
public record BookId (UUID id){


    //Canonical Constructor: is used to making another validantion when we are creating an instance of this object.
    public BookId{
        Assert.notNull(id, "it not be null"); // If it is null, so it throw an IllegalArgumentException
    }

    public BookId(){
        this(UUID.randomUUID());
    }
}
