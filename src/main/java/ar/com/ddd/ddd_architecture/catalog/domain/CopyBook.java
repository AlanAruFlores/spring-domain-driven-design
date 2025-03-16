package ar.com.ddd.ddd_architecture.catalog.domain;

import jakarta.persistence.*;

@Entity
public class CopyBook {
    @EmbeddedId
    private CopyId id;

    @Embedded
    @AttributeOverride(name="code", column = @Column(name="bar_code"))
    private BarCode barCode;

    /*
    * As we know, the copy need to get a relationship with the Book's entity.
    * But in DDD is not recommendable to use @ManyToOne, insteadOf is ueful only
    * to make reference the ID of the book
    * */

    @Embedded
    @AttributeOverride(name="id", column = @Column(name="book_id"))
    private BookId bookId;

}
