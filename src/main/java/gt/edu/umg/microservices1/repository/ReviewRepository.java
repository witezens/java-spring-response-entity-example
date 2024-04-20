package gt.edu.umg.microservices1.repository;

import gt.edu.umg.microservices1.model.ReviewEntity;
import gt.edu.umg.microservices1.model.ReviewEntityPK;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Los repositorios se crean en relación a la entidad que va representar
 * *
 * usamos la plabra clave <interface> en lugar de <class>
 * *
 * *
 * Los repositorios se utilizan para almacenar y acceder a datos de distintos tipos de bases de datos
 * En su forma más básica, un repositorio puede declararse como una interfaz Java, y Spring Data generará
 * su implementación sobre la marcha utilizando convenciones basadas en opiniones.
 * *
 * Estas convenciones pueden anularse y/o complementarse mediante una configuracion adicional y, si es
 * necesario, algo de código Java. Spring Data tambiene viene con algunas interfaces Java base por ejemplo
 * <CrudRepository>, para simplificar aún más la definición de un repositorio.
 * *
 * La interfaz base <CrudRepository> nos proporciona métodos estándar para las operaciones de creación, lectura,
 * actualización y borrado.
 * *
 * Vea que para esta ejemplo se utiliza la clase <ReviewEntityPK> que describe una llave compuesta
 * *
 * *
 * También se ha agregado un método extra llamado findByProductId que nos permite buscar una Review basada
 * en su atributo productId que es parte de la llave primaria
 */
public interface ReviewRepository extends CrudRepository<ReviewEntity, ReviewEntityPK> {
    Collection<ReviewEntity> findByProductId(Long productId);
}
