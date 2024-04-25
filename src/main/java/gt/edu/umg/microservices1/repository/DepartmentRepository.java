package gt.edu.umg.microservices1.repository;

import gt.edu.umg.microservices1.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {


    List<Department> findByActive(Boolean active);

}
