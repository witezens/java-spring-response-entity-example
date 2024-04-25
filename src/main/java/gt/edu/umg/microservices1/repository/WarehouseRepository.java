package gt.edu.umg.microservices1.repository;

import gt.edu.umg.microservices1.model.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Long> {

    @Query("select w.id, w.name, w.address, w.active from WarehouseEntity w where w.address like %?1")
    List<WarehouseEntity> findByAddress(String Address);
}
