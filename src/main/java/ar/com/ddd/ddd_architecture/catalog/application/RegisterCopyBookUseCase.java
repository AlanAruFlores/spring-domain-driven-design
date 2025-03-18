package ar.com.ddd.ddd_architecture.catalog.application;

import ar.com.ddd.ddd_architecture.catalog.domain.BarCode;
import ar.com.ddd.ddd_architecture.catalog.domain.BookId;
import ar.com.ddd.ddd_architecture.catalog.domain.CopyBook;
import ar.com.ddd.ddd_architecture.catalog.domain.CopyRepository;
import ar.com.ddd.ddd_architecture.common.UseCase;
import org.antlr.v4.runtime.misc.NotNull;

@UseCase
public class RegisterCopyBookUseCase {

    private CopyRepository copyRepository;

    public RegisterCopyBookUseCase(CopyRepository copyRepository){
        this.copyRepository = copyRepository;
    }

    /*NotNull allows to no send NULL VALUES*/
    public void execute(@NotNull BookId bookId, @NotNull BarCode barCode){
        this.copyRepository.save(new CopyBook(barCode,bookId));
    }

}
