package gt.edu.umg.microservices1.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class Address {
    @NonNull
    private String address;
    @NonNull
    private Integer id;
}
