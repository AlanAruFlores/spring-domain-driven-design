package ar.com.ddd.ddd_architecture.catalog.domain.providers;

import java.util.List;
import ar.com.ddd.ddd_architecture.catalog.domain.models.BookModel;

public interface BookDAOProvider {
        /**
     * Recupera todas las entidades del tipo T.
     *
     * @return una lista de todas las entidades.
     */
    List<BookModel> findAll();

    /**
     * Busca una entidad por su identificador.
     *
     * @param id el identificador de la entidad a buscar.
     * @return la entidad encontrada.
     */
    BookModel findById(Long id);

    /**
     * Guarda una nueva entidad o actualiza una existente.
     *
     * @param entity la entidad a guardar.
     * @return la entidad guardada.
     */
    BookModel save(BookModel entity);

    /**
     * Elimina una entidad por su identificador.
     *
     * @param id el identificador de la entidad a eliminar.
     */
    void delete(Long id);
}
