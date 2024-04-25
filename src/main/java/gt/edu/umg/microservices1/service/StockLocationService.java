package gt.edu.umg.microservices1.service;

import gt.edu.umg.microservices1.model.StockLocationEntity;
import gt.edu.umg.microservices1.repository.StockLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockLocationService {
    private final StockLocationRepository stockLocationRepository;

    @Autowired
    public StockLocationService(StockLocationRepository stockLocationRepository) {
        this.stockLocationRepository = stockLocationRepository;
    }

    public StockLocationEntity addStockLocation(StockLocationEntity stockLocation) {
        return stockLocationRepository.save(stockLocation);
    }

    public List<StockLocationEntity> getAllStockLocations() {
        return stockLocationRepository.findAll();
    }

    public Optional<StockLocationEntity> getStockLocationById(Long id) {
        return stockLocationRepository.findById(id);
    }

    public Optional<List<StockLocationEntity>> getStockLocationByWarehouseId(Long id) {
        return stockLocationRepository.findByWarehouseId(id);
    }

    public Optional<StockLocationEntity> getStockLocationByIdAndWarehouseId(Long id, Long warehouseId) {
        return stockLocationRepository.findByIdAndWarehouseId(id, warehouseId);
    }

    public Optional<List<StockLocationEntity>> getStockLocationByUsage(String usage) {
        return stockLocationRepository.findByUsage(usage);
    }

    public Optional<List<StockLocationEntity>> getStockLocationByActive(boolean active) {
        return stockLocationRepository.findByActive(active);
    }
}
