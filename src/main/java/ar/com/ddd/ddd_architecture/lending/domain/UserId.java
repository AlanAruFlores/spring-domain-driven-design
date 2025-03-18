package ar.com.ddd.ddd_architecture.lending.domain;

import org.apache.catalina.User;
import org.springframework.util.Assert;

import java.util.UUID;

public record UserId (UUID id){

    public UserId{
        Assert.notNull(id,"the userid cannot be null");
    }

    public UserId(){
        this(UUID.randomUUID());
    }
}
