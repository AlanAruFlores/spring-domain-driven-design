package ar.com.ddd.ddd_architecture.catalog.application;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Here Im going to customize a Annotation UseCase
@Retention(RetentionPolicy.RUNTIME) // Indicate that it works in time of execution
@Target(ElementType.TYPE) // It can be applied in CLASSES, INTERFACES , RECORDS, ETC.
@Service
@Validated // make that we can validate  @NotNull or another annotations
public @interface UseCase {
}
