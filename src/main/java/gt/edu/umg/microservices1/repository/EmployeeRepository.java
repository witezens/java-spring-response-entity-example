package gt.edu.umg.microservices1.repository;

import gt.edu.umg.microservices1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
