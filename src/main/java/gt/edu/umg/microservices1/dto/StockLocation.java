package gt.edu.umg.microservices1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockLocation {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String usage;
    private Boolean active;
    private int warehouseId;
}
