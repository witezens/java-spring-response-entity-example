package gt.edu.umg.microservices1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data esta anotación generará los getters, setters, toString y equalsAndHashCode,
 * por lo que no son necesarios agregarlos al DTO
 */
@Data
/**
 * @NoArgsConstructor indica que se generará el método para la creación del objeto sin argumentos
 * Ver sobrecarga de métodos
 */
@NoArgsConstructor
/**
 * @AllArgsConstructor indica que se generará el método para la creación del objeto con todos los argumentos
 * Ver sobrecarga de métodos
 */
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private String lastname;

}
