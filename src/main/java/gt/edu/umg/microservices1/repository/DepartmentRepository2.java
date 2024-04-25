package gt.edu.umg.microservices1.repository;

import gt.edu.umg.microservices1.model.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository2 extends JpaRepository<DepartmentEntity, Long> {

    List<DepartmentEntity> findByActive(boolean active);
    DepartmentEntity findByBudget(Double budget);

}
