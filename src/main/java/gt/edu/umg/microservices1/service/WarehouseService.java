package gt.edu.umg.microservices1.service;

import gt.edu.umg.microservices1.model.WarehouseEntity;
import gt.edu.umg.microservices1.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public WarehouseEntity addWarehouse(WarehouseEntity warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public List<WarehouseEntity> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Optional<WarehouseEntity> getWarehouseById(Long id) {
        return warehouseRepository.findById(id);
    }
}
