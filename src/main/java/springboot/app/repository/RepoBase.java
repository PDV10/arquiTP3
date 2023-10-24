package springboot.app.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio base(interface) común al resto de repositorios que extiende de Repository .
 *
 * @author  Elva Kheler: mekdy.20@gmail.com
 *          Héctor Liceaga: lice2187@gmail.com
 *  		Nicolás Carsaniga: nikitobombero@gmail.com
 *  		Sergio Yañez: sergiomyanez02@gmail.com
 * @version 1.0
 * @since 25/06/2022
 * @see org.springframework.data.repository.Repository
 * @param <T> Tipo de la entidad que manipula
 * @param <ID> Identificador único de la entidad que manipula
 */
@NoRepositoryBean
public interface RepoBase<T,ID extends Serializable> extends org.springframework.data.repository.Repository<T,ID> {
    /**
     * Elimina una entidad de la BD.
     * @param deleted entidad a borrar.
     */
    void delete( T deleted);

    /**
     * Retorna un listado de las entidades almacenadas.
     * @return Listado de entidades.
     */
    List<T> findAll();

    /**
     * Busca y devuelve una entidad de acuerdo al id ingresado por parámetro.
     * @param id Identificador único de la entidad.
     * @return Entidad que coicide con el id ingresado.
     */
    Optional<T> findById(Long id);

    /**
     * Indica si existe la entidad con el id ingresado por parámetro.
     * @param id Identificador único de la entidad.
     * @return True en caso de existir, caso contraio, false.
     */
    boolean existsById(Long id);

    /**
     * Elimina una entidad correspondiente al id ingresado por parámetro.
     * @param id Identificador único de la entidad.
     */
    void deleteById(Long id);

    /**
     * Persiste una entidad ingresada por parámetro.
     * @param persisted entidad a persistir
     * @return retorna la entidad persistida con el id asignado.
     */
    T save( T persisted);

}
