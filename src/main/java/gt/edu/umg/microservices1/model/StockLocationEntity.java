package gt.edu.umg.microservices1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stock_locations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockLocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String usage;
    private Boolean active;
    @Column(name = "warehouse_id")
    private int warehouseId;

//    @ManyToOne
//    @JoinColumn(name = "warehouse_id", insertable = false, updatable = false)
//    private WarehouseEntity warehouse;
}
