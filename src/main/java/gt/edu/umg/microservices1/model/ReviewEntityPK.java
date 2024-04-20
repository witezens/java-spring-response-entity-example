package gt.edu.umg.microservices1.model;

import java.io.Serializable;

/**
 * Descripción de una llave primaria compuesta
 */
public class ReviewEntityPK implements Serializable {
    public Long productId;
    public Long reviewId;
}
