package gt.edu.umg.microservices1.dto;

import lombok.Data;


/**
 * @Data esta anotación generará los getters, setters, toString y equalsAndHashCode,
 * por lo que no son necesarios agregarlos al DTO
 */
@Data
public class Team {
    Long id;
    String name;
    String description;
}
