package ar.com.ddd.ddd_architecture.lending.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    private LocalDate createdAt;

    private LocalDate expectedToReturn;

    public Loan(){
    }

    public Loan(CopyId copyId, UserId userId) {
        this.id = new LoanId();
        this.copyId = copyId;
        this.userId = userId;
        this.createdAt = LocalDate.now();
        //We increment here the amount of days to return the book
        this.expectedToReturn = LocalDate.now().plusDays(30);
    }

    public void checkReturn(){
        LocalDateTime returnDate = LocalDateTime.now();
        if(returnDate.isAfter(this.expectedToReturn.atStartOfDay())){
            // we incremente the fee
        }
    }
}
