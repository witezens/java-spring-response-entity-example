package gt.edu.umg.microservices1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/**
 * Una entidad describe la información que va ser almacenada po Spring Data. Las clases Entity son, en general
 * anotadas con una mezcla de las anotaciones genericas de Spring Data y anotaciones que son specificas para
 * cada tecnología de base de datos
 * <p>
 * Por ejemplo, una entidad que se almacenará en una base de datos relacional se puede anotar con anotaciones
 * JPA como las siguientes:
 */


@Entity
@IdClass(ReviewEntityPK.class)
@Table(name = "review")
public class ReviewEntity {
    @Id private Long productId;
    @Id private Long reviewId;
    private String author;
    private String subject;
    private String content;
}
