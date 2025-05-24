package ar.com.ddd.ddd_architecture.catalog.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ddd.ddd_architecture.catalog.infrastructure.entity.BookEntity;

public interface BookHibernateRepository extends JpaRepository<BookEntity, Long> {

}
