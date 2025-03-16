package ar.com.ddd.ddd_architecture.catalog.domain;


import org.apache.commons.validator.routines.ISBNValidator;

/*
* Record allow that the object can be inmutable (it means that the object cannot be changed).
* Also in the Book class , this is correct because An ISBN CANNOT BE MODIFIED.
* */
public record Isbn(String valueIsbn) {
    private static final ISBNValidator validator = new ISBNValidator();

    //First method to execute
    public Isbn{
        if(!validator.isValid(valueIsbn)){
            throw new IllegalArgumentException("Exception: isbn is not valid");
        }
    }



}
