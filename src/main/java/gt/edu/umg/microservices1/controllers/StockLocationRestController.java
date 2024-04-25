package gt.edu.umg.microservices1.controllers;

import gt.edu.umg.microservices1.dto.StockLocation;
import gt.edu.umg.microservices1.model.StockLocationEntity;
import gt.edu.umg.microservices1.service.StockLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/stock-locations")
public class StockLocationRestController {

    private final StockLocationService service;

    @Autowired
    public StockLocationRestController(StockLocationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody StockLocation stockLocationDTO) {

        if (stockLocationDTO.getWarehouseId() == 0) {
            System.out.println("No warehouse id provided");
            return ResponseEntity.badRequest().body("No warehouse id provided");
        }

        StockLocationEntity stockLocationEntity = new StockLocationEntity();
        stockLocationEntity.setName(stockLocationDTO.getName());
        stockLocationEntity.setUsage(stockLocationDTO.getUsage());
        stockLocationEntity.setActive(stockLocationDTO.getActive());
        stockLocationEntity.setActive(stockLocationDTO.getActive());
        stockLocationEntity.setWarehouseId(stockLocationDTO.getWarehouseId());

        StockLocationEntity e = service.addStockLocation(stockLocationEntity);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<Object> list() {
        List<StockLocationEntity> stockLocations = service.getAllStockLocations();

        return ResponseEntity.ok(stockLocations);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Optional<StockLocationEntity> e = service.getStockLocationById(id);

        return ResponseEntity.ok(e);
    }

    @GetMapping("/warehouses/{warehouseId}")
    public ResponseEntity<Object> findByWarehouseId(@PathVariable Long warehouseId) {
        Optional<List<StockLocationEntity>> e = service.getStockLocationByWarehouseId(warehouseId);

        return ResponseEntity.ok(e);
    }

    @GetMapping("/{stockLocationId}/warehouses/{warehouseId}")
    public ResponseEntity<Object> findByIdAndWarehouseId(@PathVariable Long stockLocationId, @PathVariable Long warehouseId){
        Optional<StockLocationEntity> e = service.getStockLocationByIdAndWarehouseId(stockLocationId, warehouseId);

        return ResponseEntity.ok(e);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> findByUsage(
            @RequestParam(required = false) String usage,
            @RequestParam(required = false) boolean active
    ) {

        if (usage != null) {
            Optional<List<StockLocationEntity>> e = service.getStockLocationByUsage(usage);
            return ResponseEntity.ok(e);
        }
        else if (!active || active) {
            Optional<List<StockLocationEntity>> e = service.getStockLocationByActive(active);
            return ResponseEntity.ok(e);
        }

        return null;
    }
}
