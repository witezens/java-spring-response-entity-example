package gt.edu.umg.microservices1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {
    private int id;
    @NonNull
    private String name;
    private String address;
    private Boolean active;
}
