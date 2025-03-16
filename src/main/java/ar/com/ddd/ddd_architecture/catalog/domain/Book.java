package ar.com.ddd.ddd_architecture.catalog.domain;

import jakarta.persistence.*;
import org.springframework.util.Assert;

@Entity
public class Book {
    @EmbeddedId //@Id but it can be embeebed in a class
    private BookId id;
    @Embedded
    @AttributeOverride(name = "valueIsbn", column = @Column(name="isbn")) // Here we are overriding the name of the column
    private Isbn isbn;
    private String name;

    public Book(){}

    public Book(Isbn isbn, String name) {
        Assert.notNull(isbn, "The isbn cannot be null");
        Assert.notNull(name, "The name cannot be null");

        this.id = new BookId(); // We are generate the id automatically.
        this.isbn = isbn;
        this.name = name;
    }
}
