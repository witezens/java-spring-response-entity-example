package gt.edu.umg.microservices1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "warehouse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private Boolean active;

    /** cuál es el atributo de la entidad con la que se realiza la relación
     *
     * LAZY: No me intentes obtener la relación de un usuario hasta que yo explicitamente lo solicite
     * EAGER: siempre carga las relaciones
     *
     * Información relacionada a FetchType en: https://medium.com/interleap/problems-with-hibernate-one-to-many-and-their-solutions-8f32af216b95
     **/
    @OneToMany(mappedBy = "warehouseId", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    private List<StockLocationEntity> stockLocation;
}
