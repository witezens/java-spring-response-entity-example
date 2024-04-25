package gt.edu.umg.microservices1.controllers;

import gt.edu.umg.microservices1.dto.Warehouse;
import gt.edu.umg.microservices1.model.WarehouseEntity;
import gt.edu.umg.microservices1.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/warehouses")
public class WarehouseRestController {

    private final WarehouseService service;

    @Autowired
    public WarehouseRestController(WarehouseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Warehouse warehouseDTO) {
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setName(warehouseDTO.getName());
        warehouseEntity.setAddress(warehouseDTO.getAddress());
        warehouseEntity.setActive(warehouseDTO.getActive());

        WarehouseEntity e = service.addWarehouse(warehouseEntity);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<Object> list() {
        List<WarehouseEntity> warehouses = service.getAllWarehouses();

        //<>
        return ResponseEntity.ok(warehouses);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> get(@PathVariable long id) {
        Optional<WarehouseEntity> warehouseEntity = service.getWarehouseById(id);

        if (warehouseEntity.isPresent()) {
            return ResponseEntity.ok(warehouseEntity);
        }

        return ResponseEntity.notFound().build();
    }


}
