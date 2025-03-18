package ar.com.ddd.ddd_architecture.lending.domain;

import jakarta.persistence.*;

@Entity
public class Loan {

    @EmbeddedId
    private LoanId id;

    @Embedded
    @AttributeOverride(name = "id", column=@Column(name="copy_id"))
    private CopyId copyId;

    @Embedded
    @AttributeOverride(name = "id", column=@Column(name="user_id"))
    private UserId userId;

}
