package ar.com.ddd.ddd_architecture.lending.domain;

import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<Loan, LoanId> {
}
