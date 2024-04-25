package gt.edu.umg.microservices1.repository;

import gt.edu.umg.microservices1.model.StockLocationEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockLocationRepository extends JpaRepository<StockLocationEntity, Long> {

    Optional<List<StockLocationEntity>> findByWarehouseId(long warehouseId);

    Optional<StockLocationEntity> findByIdAndWarehouseId(long id, long warehouseId);

    Optional<List<StockLocationEntity>> findByUsage(String usage);

    Optional<List<StockLocationEntity>> findByActive(boolean active);
}
