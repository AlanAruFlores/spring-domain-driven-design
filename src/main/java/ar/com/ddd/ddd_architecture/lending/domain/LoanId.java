package ar.com.ddd.ddd_architecture.lending.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record LoanId(UUID id) {

    public LoanId{
        Assert.notNull(id, "id cannot be null");
    }

    public LoanId(){
        this(UUID.randomUUID());
    }
}
