package gt.edu.umg.microservices1.model;

import jakarta.persistence.Id;
import jakarta.persistence.Version;
// import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Si una entidad ba ser almacenada en una base de datos MongoDB, las anotaciones de Spring Data MongoDB
 * van a ser utilizadas con las anotaciones genericas de Spring Data.
 * Por ejemplo vea la siguiente Clase RecommendationEntity
 *
 * (Nota) vea que la anotacion @Document es parte del paquete mongodb el cual debe ser agregado como dependencia
 * al proyecto, una vez hecho descomente las líneas 5 y 16
 */

//@Document
public class RecommendationEntity {

    @Id
    private String id;

    @Version
    private long version;

    private int productId;
    private int recommendationId;
    private String author;
    private int rate;
    private String content;
}
